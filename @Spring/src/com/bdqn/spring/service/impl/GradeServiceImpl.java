package com.bdqn.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.bdqn.spring.dao.IGradeDao;
import com.bdqn.spring.service.IGradeService;



/**
 * 年纪业务逻辑实现类
 * @author 施鹏振
 *
 */
@Service("GradeServiceImpl")//对应的Service层接口名name=bean的Id
public class GradeServiceImpl implements IGradeService {

//	@Autowired  // 默认按类型匹配
//	@Qualifier("IGradeDao") // 按指定名称匹配(对应的Dao层接口名)
//	@Autowired(required =false)//false不抛异常,true抛异常,默认true
//	public GradeServiceImpl(@Qualifier("GradeDaoImpl") IGradeDao gradeDao) {
//	    this.gradeDao = gradeDao;
//	}
//
//	@Resource()//@Resource(name="GradeDaoImpl")
//	public void setIGradeDao(IGradeDao gradeDao) {
//	    this.gradeDao = gradeDao;
//	}
	
	@Resource()//@Resource(name="GradeDaoImpl")按名称装配,没有name默认变量名,找不到在按类型找
	private IGradeDao gradeDao;
	
	
	/**
	 * 添加年纪信息
	 * @param gradeId
	 * @param gradeName
	 */
	@Override
	public void addGrade(int gradeId, String gradeName) {
		gradeDao.addGrade(gradeId, gradeName);;
	}

	/**
	 * 打印年纪信息
	 */
	@Override
	public void printGrade() {
		gradeDao.printGrade();
	}

}
