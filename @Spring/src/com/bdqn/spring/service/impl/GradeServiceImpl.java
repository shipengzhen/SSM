package com.bdqn.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.bdqn.spring.dao.IGradeDao;
import com.bdqn.spring.service.IGradeService;



/**
 * ���ҵ���߼�ʵ����
 * @author ʩ����
 *
 */
@Service("GradeServiceImpl")//��Ӧ��Service��ӿ���name=bean��Id
public class GradeServiceImpl implements IGradeService {

//	@Autowired  // Ĭ�ϰ�����ƥ��
//	@Qualifier("IGradeDao") // ��ָ������ƥ��(��Ӧ��Dao��ӿ���)
//	@Autowired(required =false)//false�����쳣,true���쳣,Ĭ��true
//	public GradeServiceImpl(@Qualifier("GradeDaoImpl") IGradeDao gradeDao) {
//	    this.gradeDao = gradeDao;
//	}
//
//	@Resource()//@Resource(name="GradeDaoImpl")
//	public void setIGradeDao(IGradeDao gradeDao) {
//	    this.gradeDao = gradeDao;
//	}
	
	@Resource()//@Resource(name="GradeDaoImpl")������װ��,û��nameĬ�ϱ�����,�Ҳ����ڰ�������
	private IGradeDao gradeDao;
	
	
	/**
	 * ��������Ϣ
	 * @param gradeId
	 * @param gradeName
	 */
	@Override
	public void addGrade(int gradeId, String gradeName) {
		gradeDao.addGrade(gradeId, gradeName);;
	}

	/**
	 * ��ӡ�����Ϣ
	 */
	@Override
	public void printGrade() {
		gradeDao.printGrade();
	}

}
