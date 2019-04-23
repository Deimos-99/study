package com.example.bean.factory.support;

import com.example.bean.BeanDefinition;

public interface BeanDefinitionRegistry {

	BeanDefinition getDefinition(String beanId);

	void registerBeanDefinition(String beanId, BeanDefinition beanDefinition);

}
