package com.mybatis.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 工厂类
 * @author 施鹏振
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;//工厂
	
	/**
	 * 创建SqlSession
	 * @param mybatisconfigxml
	 * @return
	 */
	public static SqlSession getSqlSession(String mybatisconfigxml,boolean b){
		SqlSession sqlSession=null;
		try {
			//条文
			InputStream inputStream = Resources.getResourceAsStream(mybatisconfigxml);
			//建筑队
			//SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			//工厂
			//sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			//产品
//			调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
//			第一种方式:调用selectOne方法执行查询操作
//			return sqlSession.selectOne("com.mybatis.dao.IGradeDao.insertGrade");
//			第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作(建议使用)
			sqlSession=sqlSessionFactory.openSession(b);//true为自动提交事务,false为不自动提交事务,默认false
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
			sqlSession=sqlSessionFactory.openSession(b);//true为自动提交事务,false为不自动提交事务
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
			sqlSession=sqlSessionFactory.openSession(true);//true为自动提交事务,false为不自动提交事务
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}	
	
	/**
	 * 关闭SqlSession
	 */
	/**
	 * 关闭SqlSession
	 */
	protected void closeSqlSession(SqlSession sqlSession){
		if (sqlSession!=null) {
			sqlSession.close();
		}
	}
}
