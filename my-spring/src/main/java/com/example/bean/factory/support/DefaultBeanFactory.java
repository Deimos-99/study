package com.example.bean.factory.support;

import com.example.bean.BeanDefinition;
import com.example.bean.factory.BeanCreationException;
import com.example.bean.factory.BeanDefinitionStoreException;
import com.example.bean.factory.BeanFactory;
import com.example.bean.factory.config.ConfigurableBeanFactory;
import com.example.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements ConfigurableBeanFactory, BeanDefinitionRegistry {

	private ClassLoader classLoader;

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	public DefaultBeanFactory() {
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
//		ClassLoader cl = ClassUtils.getDefaultClassLoader();
		ClassLoader cl = this.getBeanClassLoader();
		try {
			Class<?> clazz = cl.loadClass(bd.getBeanClassName());
			return clazz.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException("error creating " + bd.getBeanClassName(), e);
		}
	}

	@Override
	public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanId, beanDefinition);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public ClassLoader getBeanClassLoader() {
		return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
	}
}
