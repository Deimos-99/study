package com.example.bean.factory.config;

public interface SingletonBeanRegistry {

	void registerSingleton(String beanName, Object singleonObject);

	Object getSingleton(String beanName);

}
