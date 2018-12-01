package com.ruanyb.spring.aop;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReflectiveMethodInvocation implements MethodInvocation {
	
	private Object target;
	
	private Method method;
	
	private Object[] args;

	@Override
	public Object[] getArguments() {
		return args;
	}

	@Override
	public Object proceed() throws Throwable {
		return method.invoke(target, args);
	}

	@Override
	public Object getThis() {
		return target;
	}

	@Override
	public AccessibleObject getStaticPart() {
		return method;
	}

	@Override
	public Method getMethod() {
		return method;
	}

}
