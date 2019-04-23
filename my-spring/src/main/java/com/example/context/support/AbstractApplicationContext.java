package com.example.context.support;

import com.example.bean.factory.support.DefaultBeanFactory;
import com.example.bean.factory.xml.XmlBeanDefinitionReader;
import com.example.context.ApplicationContext;
import com.example.core.io.Resource;
import com.example.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {

	private ClassLoader classLoader;

	private DefaultBeanFactory factory;

	public AbstractApplicationContext(String path) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = this.getResrouceByPath(path);
		reader.loadDefinition(resource);
		factory.setBeanClassLoader(this.getBeanClassLoader());
	}

	@Override
	public Object getBean(String beanId) {
		return factory.getBean(beanId);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public ClassLoader getBeanClassLoader() {
		return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
	}

	public abstract Resource getResrouceByPath(String path);

}
