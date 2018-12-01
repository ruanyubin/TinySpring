package com.ruanyb.spring.aop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TargetSource {
	
	private Object target;
	
	private Class targetClass;
	
}
