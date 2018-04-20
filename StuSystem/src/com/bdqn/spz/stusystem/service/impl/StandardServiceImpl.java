package com.bdqn.spz.stusystem.service.impl;

import com.bdqn.spz.stusystem.dao.IStandardDao;
import com.bdqn.spz.stusystem.pojo.Standard;
import com.bdqn.spz.stusystem.service.IStandardService;
import com.bdqn.spz.stusystem.tools.Paging;

/**
 * Service���׼��Ϣʵ����
 * @author ʩ����
 *
 */
public class StandardServiceImpl implements IStandardService {

	private IStandardDao standardDao;
	
	public IStandardDao getStandardDao() {
		return standardDao;
	}

	public void setStandardDao(IStandardDao standardDao) {
		this.standardDao = standardDao;
	}


	//��ѯ��׼��Ϣ(��ҳ)
	@Override
	public Paging<Standard> findStandards(Paging<Standard> paging) {
		try {
			paging.setTotalCount(standardDao.selectStandardCount(paging.getT().getStdNum()));
			paging.setList(standardDao.selectStandards(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return paging;
	}

	//ɾ��һ���������׼��Ϣ
	@Override
	public boolean amputateStandards(Integer[] standardIds) {
		boolean b=false;
		try {
			if (standardDao.deleteStandards(standardIds)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	//������׼��Ϣ
	@Override
	public boolean addStandard(Standard standard) {
		boolean b=true;
		try {
			if (findStandard(standard.getStdNum())) {
				if (standardDao.insertStandard(standard)>0) {
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	//�жϱ�׼��Ϣ�Ƿ����
	@Override
	public boolean findStandard(String stdNum) {
		boolean b=true;
		try {
			if (standardDao.selectStandardByStdNum(stdNum)!=null) {
				b=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	//��ѯ��׼��Ϣ
	@Override
	public Standard findStandard(Integer standardId) {
		Standard standard=null;
		try {
			standard=standardDao.selectStandardById(standardId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return standard;
	}

	//�޸ı�׼��Ϣ
	@Override
	public boolean modifyStandard(Standard standard) {
		boolean b=true;
		try {
			if (findStandard(standard.getStdNum())) {
				if (standardDao.updateStandard(standard)>0) {
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}
	
	
	
}
