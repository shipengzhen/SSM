package com.spz.class_class;

public class Person {

	// ��Ա�ڲ���
	class InnerPerson1 {

	}

	// ��̬�ڲ���,��̬Ƕ���಻�����ڲ��ࡣ
	//��Ϊ�ڲ������ⲿ�๲��һ�������ϵ����ȷ�е�˵�Ƕ�ʵ���Ĺ����ϵ��
	//����̬Ƕ������û��������ϵ��
	//��ֻ��λ������һ������ڲ������Ҳ����Ϊ����Ƕ���ࡣ
	static class InnerPerson2 {

	}

	/*
	 * �����ڲ���: 1.�����ڲ���ֻ���ڶ�����ڲ���ķ�����ʵ�������������ڴ˷��������ʵ������
	 * 2.�����ڲ��������ʹ�ø��ڲ������ڷ����ķ�final�ֲ�����
	 */
	public void setClass() {
		class InnerPerson1 {
			public void getInnerPerson1(){
				System.out.println("���Ƿ����ڲ���");
			}
		}
		new InnerPerson1().getInnerPerson1();
	}

	// �����ڲ���,�������Լ��ķ���(���ᱨ��,���޷�����)
	// 1.�̳�ʽ�������ڲ���
	Father father = new Father() {
		
		//���������ڲ�����д
		@Override
		public void getFather() {
			System.out.println("��������");
		}
	};

	//2.�ӿ�ʽ�������ڲ���,�ӿ�ʽ�������ڲ�����ʵ����һ���ӿڵ������ࡣ����ֻ��ʵ��һ���ӿڡ�
	IFather iFather=new IFather() {
		
		@Override
		public void getFather() {
			System.out.println("���ǰְ�");
		}
	}; 
	
	public static void main(String[] args) {
		Person person=new Person();
		//1.�̳�ʽ�������ڲ���
		person.father.getFather();
		//2.�ӿ�ʽ�������ڲ���
		person.iFather.getFather();
		//3.����ʽ�������ڲ���
		person.father.getFather(new IFather() {
			
			@Override
			public void getFather() {
				System.out.println("����");	
			}
		});
	}
}
