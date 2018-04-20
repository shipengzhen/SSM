package com.bdqn.spring.uitl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringUtil {

	//创建ApplicationContext对象
	private static ApplicationContext  applicationContext;
	
	
	public static ApplicationContext getApplicationContext(){
		//通过ClassPathXmlApplicationContext示例化Spring的上下文
		return applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	public static Object getObject(String id){
		applicationContext=getApplicationContext();
		//通过ApplicationContext的getBean()方法,根据id来获取Bean的实例
		return applicationContext.getBean(id);
	}
	
	public static ApplicationContext getApplicationContext(String applicationContextxml){
		//通过ClassPathXmlApplicationContext示例化Spring的上下文
		return applicationContext=new ClassPathXmlApplicationContext(applicationContextxml);
	}
	
	public static Object getObject(String applicationContextxml,String id){
		applicationContext=getApplicationContext(applicationContextxml);
		//通过ApplicationContext的getBean()方法,根据id来获取Bean的实例
		return applicationContext.getBean(id);
	}
}
