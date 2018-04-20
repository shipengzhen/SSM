package com.bdqn.ms.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringUtil {

	//����ApplicationContext����
	private static ApplicationContext  applicationContext;
	
	public static ApplicationContext getApplicationContext(){
		//ͨ��ClassPathXmlApplicationContextʾ����Spring��������
		return applicationContext=new ClassPathXmlApplicationContext("applicationContext*.xml");
	}
	
	public static Object getObject(String id){
		applicationContext=getApplicationContext();
		//ͨ��ApplicationContext��getBean()����,����id����ȡBean��ʵ��
		return applicationContext.getBean(id);
	}
	
	public static ApplicationContext getApplicationContext(String applicationContextxml){
		//ͨ��ClassPathXmlApplicationContextʾ����Spring��������
		return applicationContext=new ClassPathXmlApplicationContext(applicationContextxml);
	}
	
	public static Object getObject(String applicationContextxml,String id){
		applicationContext=getApplicationContext(applicationContextxml);
		//ͨ��ApplicationContext��getBean()����,����id����ȡBean��ʵ��
		return applicationContext.getBean(id);
	}
	
	
	
	public static ApplicationContext getApplicationContext(String applicationContextxml,String applicationContextdaoxml,String applicationContextservicexml){
		//ͨ��ClassPathXmlApplicationContextʾ����Spring��������
		return applicationContext=new ClassPathXmlApplicationContext(applicationContextxml,applicationContextdaoxml,applicationContextservicexml);
	}
	
	public static Object getObject(String applicationContextxml,String applicationContextdaoxml,String applicationContextservicexml,String id){
		applicationContext=getApplicationContext(applicationContextxml, applicationContextdaoxml, applicationContextservicexml);
		//ͨ��ApplicationContext��getBean()����,����id����ȡBean��ʵ��
		return applicationContext.getBean(id);
	}
}
