package com.ruanyb.spring.ioc.beans.factory;

import java.lang.reflect.Field;

import com.ruanyb.spring.ioc.BeanReference;
import com.ruanyb.spring.ioc.beans.BeanDefinition;
import com.ruanyb.spring.ioc.beans.PropertyValue;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	public Object doCreateBean(BeanDefinition beanDefinition) throws Exception {

		Object bean = createBean(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

	private Object applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
		for(PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()) {
			Field field = bean.getClass().getDeclaredField(pv.getName());
			Object value = pv.getValue();
			field.setAccessible(true);
			if(value instanceof BeanReference) {
				BeanReference beanRef = (BeanReference) value;
				field.set(bean, super.getBean(beanRef.getName()));
			}else {
				field.set(bean, pv.getValue());
			}
		}
		return bean;
	}

	private Object createBean(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}
	
}
