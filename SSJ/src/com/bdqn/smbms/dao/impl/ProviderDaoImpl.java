package com.bdqn.smbms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bdqn.smbms.dao.IProviderDao;
import com.bdqn.smbms.entity.Provider;
import com.bdqn.smbms.util.BaseDao;

/**
 * Dao层供应商实现类
 * 
 * @author 施鹏振
 *
 */
@Repository
public class ProviderDaoImpl extends BaseDao implements IProviderDao {

	// 模糊查询供应商数量
	@Override
	public int findPCount(String proCode, String proName) throws Exception {
		String sql = "select count(*) from provider where proCode like concat('%',?,'%') and proName like concat('%',?,'%')";
		Object[] objects = { proCode, proName };
		return count(sql, objects);
	}

	// 模糊查询供应商
	@Override
	public List<Provider> findProviders(String proCode, String proName, int currentPageNo, int pageSize)
			throws Exception {
		String sql = "select * from provider where proCode like concat('%',?,'%') and proName like concat('%',?,'%') limit ?,?";
		Object[] objects = { proCode, proName, (currentPageNo - 1) * pageSize, pageSize };
		return getList(Provider.class, sql, objects);
	}

	// 添加供应商
	@Override
	public int addUser(Provider provider, BaseDao baseDao) throws Exception {
		String sql = "insert into Provider values(null,?,?,?,?,?,?,?,?,?,NULL,NULL,?,?)";
		Object[] objects = { provider.getProCode(), provider.getProName(), provider.getProDesc(),
				provider.getProContact(), provider.getProPhone(), provider.getProAddress(), provider.getProFax(),
				provider.getCreatedBy(), provider.getCreationDate(), provider.getCompanyLicPicPath(),
				provider.getOrgCodePicPath() };
		return baseDao.exUpdate(sql, objects);
	}

	// 通过供应商Id查询供应商信息
	@Override
	public Provider findProvider(int providerId) throws Exception {
		String sql = "select id,proCode,proName,proContact,proPhone,proAddress,proFax,proDesc,companyLicPicPath,orgCodePicPath "
				+ "from provider where id=?";
		return getObject(Provider.class, sql, providerId);
	}

	// 通过供应商Id修改供应商信息
	@Override
	public int modifyProvider(Provider provider) throws Exception {
		String sql = "update provider set proCode=?,proName=?,proContact=?,proPhone=?,proAddress=?,proFax=?,proDesc=? where id=?";
		Object[] objects = { provider.getProCode(), provider.getProName(), provider.getProContact(),
				provider.getProPhone(), provider.getProAddress(), provider.getProFax(), provider.getProDesc(),
				provider.getId() };
		return exUpdate(sql, objects);
	}
}
