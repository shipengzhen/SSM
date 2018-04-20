package com.spz.singleton;

/**
 * ¿¡∫∫ƒ£ Ω
 * @author  ©≈Ù’Ò
 *
 */
public class Singleton3 {

	
	private Singleton3(){
		super();
	}
	
	public static Singleton3 getSingleton(){
		if (singleton3==null) {
			singleton3=new Singleton3();
		}
		return singleton3;
	}
	
	private static Singleton3 singleton3;
}
