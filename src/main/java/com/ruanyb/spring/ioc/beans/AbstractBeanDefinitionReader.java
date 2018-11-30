package com.ruanyb.spring.ioc.beans;

import java.util.HashMap;
import java.util.Map;

import com.ruanyb.spring.ioc.beans.io.ResourceLoader;

import lombok.Getter;

@Getter
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
	
	private Map<String, BeanDefinition> register;
	
	private ResourceLoader resourceLoader;
	
	protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.register = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	@Override
	public abstract void loadBeanDefinitions(String location) throws Exception;
	
}
