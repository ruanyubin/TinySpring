package com.ruanyb.spring.ioc.beans;


public interface BeanDefinitionReader {
	
	void loadBeanDefinitions(String location) throws Exception;
}
