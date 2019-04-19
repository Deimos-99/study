package com.example.bean.factory;

import com.example.bean.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {

	private String id;

	private String beanClassName;

	public GenericBeanDefinition(String id, String beanClassName) {
		this.id = id;
		this.beanClassName = beanClassName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}
}
