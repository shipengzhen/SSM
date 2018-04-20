package com.spz.singleton;


/**
 * �Ǽ�ģʽ
 * @author ʩ����
 *
 */
public class Singleton {

	
	private Singleton(){
		super();
	}
	
	public static Singleton getSingleton(){
		return InnerSingleton.singleton;
	}
	
	//��̬�ڲ���
	static class InnerSingleton{
		static Singleton singleton=new Singleton();
	}
}
