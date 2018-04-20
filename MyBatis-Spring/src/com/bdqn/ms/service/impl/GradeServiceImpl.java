package com.bdqn.ms.service.impl;


import java.util.List;
import com.bdqn.ms.dao.IGradeDao;
import com.bdqn.ms.entity.Grade;
import com.bdqn.ms.service.IGradeService;

/**
 * Service层年纪实现类
 * @author 施鹏振
 *
 */
public class GradeServiceImpl implements IGradeService {

	private IGradeDao gradeDao;
	
	public IGradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(IGradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	/**
	 * 查询全部年纪
	 * @return List<Grade>
	 */
	@Override
	public List<Grade> getAllGrades() {
		return gradeDao.getAllGrades();
	}

}
