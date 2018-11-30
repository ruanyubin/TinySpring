package com.ruanyb.spring.ioc.beans.factory;

import com.ruanyb.spring.ioc.beans.BeanDefinition;

public interface BeanFactory {
	
	Object getBean(String name) throws Exception;
	
}
