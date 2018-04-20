package com.spz.singleton;

/**
 * ¶öººÄ£Ê½
 * @author Ê©ÅôÕñ
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
