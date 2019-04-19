package com.example.bean.factory;

import com.example.bean.BeanDefinition;

public interface BeanFactory {

	BeanDefinition getDefinition(String beanId);

	Object getBean(String beanId);
}
