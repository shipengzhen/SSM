package com.spz.singleton;


/**
 * 登记模式
 * @author 施鹏振
 *
 */
public class Singleton {

	
	private Singleton(){
		super();
	}
	
	public static Singleton getSingleton(){
		return InnerSingleton.singleton;
	}
	
	//静态内部类
	static class InnerSingleton{
		static Singleton singleton=new Singleton();
	}
}
