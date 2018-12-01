package com.ruanyb.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
	
	private AdvisedSupport advised;
	
	
	@Override
	public Object getProxy() {
		// TODO Auto-generated method stub
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {advised.getTargetSource().getTargetClass()}, this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
		return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
	}

}
