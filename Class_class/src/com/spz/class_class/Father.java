package com.spz.class_class;

public class Father {

	public void getFather(){
		System.out.println("���ǰְ�");
	}
	
	void getFather(IFather iFather){
		iFather.getFather();
	}
}
