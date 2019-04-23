package com.example.bean.factory.support;

import com.example.bean.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {

	private String id;

	private String beanClassName;

	private String scope = BeanDefinition.SCOPE_DEFAULT;

	private boolean isSingleton = true;

	private boolean isPrototype = false;

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

	@Override
	public boolean isSingleton() {
		return this.isSingleton;
	}

	@Override
	public boolean isPrototype() {
		return this.isPrototype;
	}

	@Override
	public String getScope() {
		return this.scope;
	}

	@Override
	public void setScope(String scope) {
		this.scope = scope;
		this.isSingleton = BeanDefinition.SCOPE_DEFAULT.equals(scope)
				|| BeanDefinition.SCOPE_SINGLETON.equals(scope);
		this.isPrototype = BeanDefinition.SCOPE_PROTOTYPE.equals(scope);
	}
}
