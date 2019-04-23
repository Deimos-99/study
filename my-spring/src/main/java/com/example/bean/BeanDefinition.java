package com.example.bean;

public interface BeanDefinition {

	String SCOPE_SINGLETON = "singleton";

	String SCOPE_PROTOTYPE = "prototype";

	String SCOPE_DEFAULT = "";

	String getBeanClassName();

	boolean isSingleton();

	boolean isPrototype();

	String getScope();

	void setScope(String scope);
}
