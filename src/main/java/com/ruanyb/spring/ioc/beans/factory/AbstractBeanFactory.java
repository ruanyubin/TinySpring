package com.ruanyb.spring.ioc.beans.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ruanyb.spring.ioc.beans.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory {
	
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	@Override
	public Object getBean(String name) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if(beanDefinition == null) {
			throw new IllegalArgumentException("no bean named " + name + " is defined");
		}
		Object bean = beanDefinition.getBean();
		if(bean == null) {
			bean = doCreateBean(beanDefinition);
		}
		return bean;
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		// TODO Auto-generated method stub
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	public abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}