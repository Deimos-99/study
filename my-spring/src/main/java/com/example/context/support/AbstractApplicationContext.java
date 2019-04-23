package com.example.context.support;

import com.example.bean.factory.support.DefaultBeanFactory;
import com.example.bean.factory.xml.XmlBeanDefinitionReader;
import com.example.context.ApplicationContext;
import com.example.core.io.Resource;

public abstract class AbstractApplicationContext implements ApplicationContext {

	private DefaultBeanFactory factory;

	public AbstractApplicationContext(String path) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadDefinition(this.getResrouce(path));
	}

	@Override
	public Object getBean(String beanId) {
		return factory.getBean(beanId);
	}

	public abstract Resource getResrouce(String path);

}
