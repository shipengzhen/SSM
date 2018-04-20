package com.mybatis.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * ������
 * @author ʩ����
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;//����
	
	/**
	 * ����SqlSession
	 * @param mybatisconfigxml
	 * @return
	 */
	public static SqlSession getSqlSession(String mybatisconfigxml,boolean b){
		SqlSession sqlSession=null;
		try {
			//����
			InputStream inputStream = Resources.getResourceAsStream(mybatisconfigxml);
			//������
			//SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			//����
			//sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			//��Ʒ
//			����mapper�ļ��������ݽ��в����������Ȱ�mapper�ļ����뵽mybatis-config.xml��
//			��һ�ַ�ʽ:����selectOne����ִ�в�ѯ����
//			return sqlSession.selectOne("com.mybatis.dao.IGradeDao.insertGrade");
//			�ڶ��ַ�ʽ:����getMapper(Mapper.class)ִ��dao�ӿڷ�����ʵ�ֶ����ݿ�Ĳ�ѯ����(����ʹ��)
			sqlSession=sqlSessionFactory.openSession(b);//trueΪ�Զ��ύ����,falseΪ���Զ��ύ����,Ĭ��false
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
	
	public static SqlSession getSqlSession(boolean b){
		SqlSession sqlSession=null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession=sqlSessionFactory.openSession(b);//trueΪ�Զ��ύ����,falseΪ���Զ��ύ����
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}	
	
	public static SqlSession getSqlSession(){
		SqlSession sqlSession=null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession=sqlSessionFactory.openSession(true);//trueΪ�Զ��ύ����,falseΪ���Զ��ύ����
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}	
	
	/**
	 * �ر�SqlSession
	 */
	/**
	 * �ر�SqlSession
	 */
	protected void closeSqlSession(SqlSession sqlSession){
		if (sqlSession!=null) {
			sqlSession.close();
		}
	}
}
