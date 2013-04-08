package com.banshan.lifebarServer.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblUser;


public interface UserInfoService extends BaseService<TblUser>{
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract TblUser findUserByAccount(String account);
}
