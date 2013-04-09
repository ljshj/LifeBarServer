package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblCompany;

public interface OrgInfoService extends BaseService<TblCompany> {
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract TblCompany findOrgByAccount(String account);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblCompany> findSubOrgsByOrgId(int orgId);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblCompany> findSubOrgsByOrgIdRecursive(int orgId);

}
