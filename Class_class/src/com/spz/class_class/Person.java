package com.spz.class_class;

public class Person {

	// 成员内部类
	class InnerPerson1 {

	}

	// 静态内部类,静态嵌套类不属于内部类。
	//因为内部类与外部类共享一种特殊关系，更确切地说是对实例的共享关系。
	//而静态嵌套类则没有上述关系。
	//它只是位置在另一个类的内部，因此也被称为顶级嵌套类。
	static class InnerPerson2 {

	}

	/*
	 * 方法内部类: 1.方法内部类只能在定义该内部类的方法内实例化，不可以在此方法外对其实例化。
	 * 2.方法内部类对象不能使用该内部类所在方法的非final局部变量
	 */
	public void setClass() {
		class InnerPerson1 {
			public void getInnerPerson1(){
				System.out.println("我是方法内部类");
			}
		}
		new InnerPerson1().getInnerPerson1();
	}

	// 匿名内部类,不能有自己的方法(不会报错,但无法调用)
	// 1.继承式的匿名内部类
	Father father = new Father() {
		
		//利用匿名内部类重写
		@Override
		public void getFather() {
			System.out.println("哈哈哈哈");
		}
	};

	//2.接口式的匿名内部类,接口式的匿名内部类是实现了一个接口的匿名类。而且只能实现一个接口。
	IFather iFather=new IFather() {
		
		@Override
		public void getFather() {
			System.out.println("我是爸爸");
		}
	}; 
	
	public static void main(String[] args) {
		Person person=new Person();
		//1.继承式的匿名内部类
		person.father.getFather();
		//2.接口式的匿名内部类
		person.iFather.getFather();
		//3.参数式的匿名内部类
		person.father.getFather(new IFather() {
			
			@Override
			public void getFather() {
				System.out.println("嘻嘻");	
			}
		});
	}
}
