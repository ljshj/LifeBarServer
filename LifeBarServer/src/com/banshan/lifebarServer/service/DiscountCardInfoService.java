package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblDiscountcard;

public interface DiscountCardInfoService extends BaseService<TblDiscountcard>{

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblDiscountcard> findCardByOrgId(int Id, int offset, int pagesize);

}
