package com.spz;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//�ֶΡ�ö�ٵĳ���
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {

	String string() default "111";
}
