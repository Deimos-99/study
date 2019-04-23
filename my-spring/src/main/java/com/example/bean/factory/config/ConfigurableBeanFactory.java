package com.example.bean.factory.config;

import com.example.bean.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {

	void setBeanClassLoader(ClassLoader classLoader);

	ClassLoader getBeanClassLoader();

}
