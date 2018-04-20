package com.bdqn.spz.stusystem.service.impl;

import com.bdqn.spz.stusystem.dao.IStandardDao;
import com.bdqn.spz.stusystem.pojo.Standard;
import com.bdqn.spz.stusystem.service.IStandardService;
import com.bdqn.spz.stusystem.tools.Paging;

/**
 * Service层标准信息实现类
 * @author 施鹏振
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


	//查询标准信息(分页)
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

	//删除一条或多条标准信息
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

	//新增标准信息
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

	//判断标准信息是否存在
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

	//查询标准信息
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

	//修改标准信息
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
