package com.example.bean.factory.support;

import com.example.bean.BeanDefinition;
import com.example.bean.factory.BeanCreationException;
import com.example.bean.factory.BeanDefinitionStoreException;
import com.example.bean.factory.BeanFactory;
import com.example.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

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
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
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
}
