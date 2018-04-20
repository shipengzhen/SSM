package com.bdqn.spz.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdqn.spz.ssm.dao.IProviderDao;
import com.bdqn.spz.ssm.pojo.Provider;
import com.bdqn.spz.ssm.service.IProviderService;

/**
 * Service�㹩Ӧ��ʵ����
 * @author ʩ����
 *
 */
@Service
public class ProviderServiceImpl implements IProviderService {

	@Resource
	private IProviderDao providerDao;

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
