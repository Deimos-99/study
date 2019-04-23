package com.example.bean.factory;

import com.example.bean.BeanDefinition;

public interface BeanFactory {

	Object getBean(String beanId);
}
