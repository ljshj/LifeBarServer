package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.SgUserInfo;

public interface SgUserInfoService {
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<SgUserInfo> findByUserPhone(String userPhone);
}
