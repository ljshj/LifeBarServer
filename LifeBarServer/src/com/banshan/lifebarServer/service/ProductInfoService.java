package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblProduct;
import com.banshan.lifebarServer.model.TblTypeOfProduct;

public interface ProductInfoService extends BaseService<TblProduct> {
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblProduct> findProductsByOrgId(int Id, int offset, int pagesize);
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblProduct> findProductsByOrgIdWithTypeId(int Id, int typeId, int offset, int pagesize);
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblTypeOfProduct> findAllTypesWithProductId(long productId);
	
	public abstract void addProductToType(long productId, int typeId);
	public abstract void dropTypeFromProduct(long productId, int typeId);
	
}
