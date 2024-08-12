package com.subrutin.lingkar.catalog.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PastTime {
	String message() default "Must be a past date";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
