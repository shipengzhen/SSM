package com.bdqn.ms.service.impl;


import java.util.List;
import com.bdqn.ms.dao.IGradeDao;
import com.bdqn.ms.entity.Grade;
import com.bdqn.ms.service.IGradeService;

/**
 * Service�����ʵ����
 * @author ʩ����
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
	 * ��ѯȫ�����
	 * @return List<Grade>
	 */
	@Override
	public List<Grade> getAllGrades() {
		return gradeDao.getAllGrades();
	}

}
