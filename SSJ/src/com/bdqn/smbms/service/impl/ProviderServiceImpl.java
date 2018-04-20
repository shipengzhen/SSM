package com.bdqn.smbms.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdqn.smbms.dao.IProviderDao;
import com.bdqn.smbms.entity.Provider;
import com.bdqn.smbms.service.IProviderService;
import com.bdqn.smbms.util.BaseDao;

/**
 * Service�㹩Ӧ��ʵ����
 * 
 * @author ʩ����
 *
 */
@Service
public class ProviderServiceImpl implements IProviderService {

	@Resource
	private IProviderDao providerDao;

	// ģ����ѯ��Ӧ������
	@Override
	public int findPCount(String proCode, String proName) {
		int count = 0;
		try {
			count = providerDao.findPCount(proCode, proName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// ģ����ѯ��Ӧ��
	@Override
	public List<Provider> findProviders(String proCode, String proName, int currentPageNo, int pageSize) {
		List<Provider> providers = new ArrayList<Provider>();
		try {
			providers = providerDao.findProviders(proCode, proName, currentPageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return providers;
	}

	// ��ӹ�Ӧ��
	@Override
	public boolean addUser(Provider provider) {
		BaseDao baseDao = new BaseDao();
		int count = 0;
		boolean b = false;
		try {
			baseDao.setCommit(false);
			count = providerDao.addUser(provider, baseDao);
			if (count > 0) {
				baseDao.commit();
				;
				b = true;
			} else {
				baseDao.rollback();
			}
		} catch (Exception e) {
			try {
				baseDao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			baseDao.closeConnection();
		}
		return b;
	}

	// ͨ����Ӧ��Id��ѯ��Ӧ����Ϣ
	@Override
	public Provider findProvider(int providerId) {
		Provider provider = null;
		try {
			provider = providerDao.findProvider(providerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provider;
	}

	// ͨ����Ӧ��Id�޸Ĺ�Ӧ����Ϣ
	@Override
	public boolean modifyProvider(Provider provider) {
		boolean b = false;
		try {
			if (providerDao.modifyProvider(provider) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
