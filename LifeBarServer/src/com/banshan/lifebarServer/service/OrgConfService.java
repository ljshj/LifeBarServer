package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblCompanyConf;

public interface OrgConfService extends BaseService<TblCompanyConf>
{
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblCompanyConf> findConfByOrgId(int orgId);
	
	public abstract void update(int orgId, String key, String value);

}
