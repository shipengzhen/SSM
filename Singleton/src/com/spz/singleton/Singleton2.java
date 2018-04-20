package com.spz.singleton;

/**
 * ����ģʽ
 * @author ʩ����
 *
 */
public class Singleton2 {

	
	private Singleton2(){
		super();
	}
	
	public static synchronized Singleton2 getSingleton(){
		return singleton2;
	}
	
	private static Singleton2 singleton2=new Singleton2();
}
