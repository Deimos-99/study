package com.example.bean.factory;

import com.example.bean.BeansException;

public class BeanDefinitionStoreException extends BeansException {

	public BeanDefinitionStoreException(String msg) {
		super(msg);
	}

	public BeanDefinitionStoreException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
