package com.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil2 {

	private static SqlSessionFactory sqlSessionFactory;//����
	
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession(true);//trueΪ�Զ��ύ����,falseΪ���Զ��ύ����
	}
	
	public static SqlSession getSqlSession(boolean b) {
		return sqlSessionFactory.openSession(b);//trueΪ�Զ��ύ����,falseΪ���Զ��ύ����
	}
	
	/**
	 * �ر�SqlSession
	 */
	protected void closeSqlSession(SqlSession sqlSession){
		if (sqlSession!=null) {
			sqlSession.close();
		}
	}
}
