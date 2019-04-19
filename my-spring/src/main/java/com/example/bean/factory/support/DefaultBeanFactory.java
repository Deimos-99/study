package com.example.bean.factory.support;

import com.example.bean.BeanDefinition;
import com.example.bean.factory.BeanCreationException;
import com.example.bean.factory.BeanDefinitionStoreException;
import com.example.bean.factory.BeanFactory;
import com.example.bean.factory.GenericBeanDefinition;
import com.example.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements BeanFactory {

	public static final String ID_ATTRIBUTE = "id";

	public static final String CLASS_ATTRIBUTE = "class";

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	public DefaultBeanFactory(String configFile) {
		this.loadDefinition(configFile);
	}

	@Override
	public BeanDefinition getDefinition(String beanId) {
		return beanDefinitionMap.get(beanId);
	}

	@Override
	public Object getBean(String beanId) {
		BeanDefinition bd = beanDefinitionMap.get(beanId);
		if (bd == null) {
			throw new BeanCreationException("Bean definition does not exists");
		}
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
		try {
			Class<?> clazz = cl.loadClass(bd.getBeanClassName());
			return clazz.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException("error creating " + bd.getBeanClassName(), e);
		}
	}

	private void loadDefinition(String configFile) {
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
		InputStream is = cl.getResourceAsStream(configFile);

		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(is);
			Element rootEle = document.getRootElement();
			Iterator<Element> elementIter = rootEle.elementIterator();
			while (elementIter.hasNext()) {
				Element element = elementIter.next();
				String id = element.attributeValue(ID_ATTRIBUTE);
				String beanClassName = element.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition beanDefinition = new GenericBeanDefinition(id,beanClassName);
				beanDefinitionMap.put(id, beanDefinition);
			}
		} catch (Exception e) {
			throw new BeanDefinitionStoreException("read xml file error", e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
