package com.ruanyb.spring.ioc.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BeanDefinition {
	
	private Object bean;
	
	private Class beanClass;
	
	private String beanClassName;
	
	private PropertyValues propertyValues = new PropertyValues();
	
	public void setBeanClassName(String name) {
		this.beanClassName = name;
		try {
			beanClass = Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
