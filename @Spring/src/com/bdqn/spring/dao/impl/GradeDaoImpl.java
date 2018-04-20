package com.bdqn.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.bdqn.spring.dao.IGradeDao;
import com.bdqn.spring.entity.Grade;
import com.bdqn.spring.uitl.SpringUtil;


/**
 * 年纪实现类
 * @author 施鹏振
 *
 */
/*@Component("IGradeDao")与<bean id="IGradeDao" class="com.bdqn.spring.dao.IGradeDao">作用一致
 * @Repositoy:用于标注Dao类
 * @Service:用于标注业务类
 * @Controller:用于标注控制器类
 */
@Repository("GradeDaoImpl")
public class GradeDaoImpl implements IGradeDao {

	/**
	 * 添加年纪信息
	 * @param gradeId
	 * @param gradeName
	 */
	@Override
	public void addGrade(int gradeId,String gradeName) {
		Grade grade=(Grade)SpringUtil.getObject("Grade");
		grade.setGradeId(gradeId);
		grade.setGradeName(gradeName);
		System.out.println("年纪ID:"+grade.getGradeId()+"\t年纪名称:"+grade.getGradeName());
	}

	/**
	 * 打印年纪信息
	 */
	@Override
	public void printGrade() {
		Grade grade=(Grade)SpringUtil.getObject("Grade");
		System.out.println("年纪ID:"+grade.getGradeId()+"\t年纪名称:"+grade.getGradeName());
	}

}
