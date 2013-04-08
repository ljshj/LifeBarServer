package com.banshan.lifebarServer.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblCompany;

public interface OrgInfoService extends BaseService<TblCompany> {
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract TblCompany findOrgByAccount(String account);

}
