package com.spz;


@ClassAnnotation(name="aass")
public class TextMyAnnotation {

	
	public static void main(String[] args) {
		
		String string;
		System.out.println(ClassAnnotation.class.getName());
		System.out.println(TextMyAnnotation.class.getName());
		if (TextMyAnnotation.class.isAnnotationPresent(ClassAnnotation.class)) {
			// 若存在就获取注解
			ClassAnnotation annotation = (ClassAnnotation) TextMyAnnotation.class.getAnnotation(ClassAnnotation.class);
			System.out.println(annotation);
			// 获取注解属性
			System.out.println(ClassAnnotation.string);
			System.out.println(annotation.name());
		}
	}
}
