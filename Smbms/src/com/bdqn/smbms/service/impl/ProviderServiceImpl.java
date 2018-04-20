package com.bdqn.smbms.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.bdqn.smbms.dao.IProviderDao;
import com.bdqn.smbms.entity.Provider;
import com.bdqn.smbms.service.IProviderService;
/**
 * Service�㹩Ӧ��ʵ����
 * @author ʩ����
 *
 */
public class ProviderServiceImpl implements IProviderService {

	private IProviderDao providerDao;//dao�㹩Ӧ�̽ӿ�
	
	public IProviderDao getProviderDao() {
		return providerDao;
	}

	public void setProviderDao(IProviderDao providerDao) {
		this.providerDao = providerDao;
	}

	//ģ����ѯ��Ӧ������
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

	//ģ����ѯ��Ӧ��
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

	//��ӹ�Ӧ��
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

	//ͨ����Ӧ��Id��ѯ��Ӧ����Ϣ
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

	//ͨ����Ӧ��Id�޸Ĺ�Ӧ����Ϣ
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
