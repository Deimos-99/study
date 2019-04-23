package com.example.bean.factory.xml;

import com.example.bean.BeanDefinition;
import com.example.bean.factory.BeanDefinitionStoreException;
import com.example.bean.factory.support.BeanDefinitionRegistry;
import com.example.bean.factory.support.GenericBeanDefinition;
import com.example.core.io.Resource;
import com.example.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {

	public static final String ID_ATTRIBUTE = "id";

	public static final String CLASS_ATTRIBUTE = "class";

	public static final String SCOPE_ATTRIBUTE = "scope";

	private BeanDefinitionRegistry registry;

	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}

	public void loadDefinition(Resource resource) {
		//ClassLoader cl = ClassUtils.getDefaultClassLoader();
		//InputStream is = cl.getResourceAsStream(configFile);
		InputStream is = null;

		SAXReader saxReader = new SAXReader();
		try {
			is = resource.getInputStream();
			Document document = saxReader.read(is);
			Element rootEle = document.getRootElement();
			Iterator<Element> elementIter = rootEle.elementIterator();
			while (elementIter.hasNext()) {
				Element element = elementIter.next();
				String id = element.attributeValue(ID_ATTRIBUTE);
				String beanClassName = element.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition beanDefinition = new GenericBeanDefinition(id,beanClassName);
				if (element.attributeValue(SCOPE_ATTRIBUTE) != null) {
					beanDefinition.setScope(element.attributeValue(SCOPE_ATTRIBUTE));
				}
				registry.registerBeanDefinition(id, beanDefinition);
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
