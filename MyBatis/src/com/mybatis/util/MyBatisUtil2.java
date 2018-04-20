package com.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil2 {

	private static SqlSessionFactory sqlSessionFactory;//工厂
	
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
		return sqlSessionFactory.openSession(true);//true为自动提交事务,false为不自动提交事务
	}
	
	public static SqlSession getSqlSession(boolean b) {
		return sqlSessionFactory.openSession(b);//true为自动提交事务,false为不自动提交事务
	}
	
	/**
	 * 关闭SqlSession
	 */
	protected void closeSqlSession(SqlSession sqlSession){
		if (sqlSession!=null) {
			sqlSession.close();
		}
	}
}
