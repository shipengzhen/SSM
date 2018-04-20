package com.bdqn.smbms.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.bdqn.smbms.dao.IProviderDao;
import com.bdqn.smbms.entity.Provider;
import com.bdqn.smbms.service.IProviderService;
/**
 * Service层供应商实现类
 * @author 施鹏振
 *
 */
public class ProviderServiceImpl implements IProviderService {

	private IProviderDao providerDao;//dao层供应商接口
	
	public IProviderDao getProviderDao() {
		return providerDao;
	}

	public void setProviderDao(IProviderDao providerDao) {
		this.providerDao = providerDao;
	}

	//模糊查询供应商数量
	@Override
	public int findPCount(String proCode, String proName) {
		int count=0;
		try {
			count=providerDao.findPCount(proCode, proName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//模糊查询供应商
	@Override
	public List<Provider> findProviders(String proCode, String proName, int currentPageNo, int pageSize) {
		List<Provider> providers=new ArrayList<Provider>();
		try {
			providers=providerDao.findProviders(proCode, proName, (currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return providers;
	}

	//添加供应商
	@Override
	public boolean addUser(Provider provider) {
		boolean b=false;
		try {
			if (providerDao.addUser(provider)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//通过供应商Id查询供应商信息
	@Override
	public Provider findProvider(int providerId) {
		Provider provider=null;
		try {
			provider=providerDao.findProvider(providerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provider;
	}

	//通过供应商Id修改供应商信息
	@Override
	public boolean modifyProvider(Provider provider) {
		boolean b=false;
		try {
			if (providerDao.modifyProvider(provider)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
}
