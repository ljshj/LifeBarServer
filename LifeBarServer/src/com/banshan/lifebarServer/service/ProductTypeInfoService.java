package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblProduct;
import com.banshan.lifebarServer.model.TblProductType;

public interface ProductTypeInfoService extends BaseService<TblProductType>
{
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract TblProductType findProductTypeParentByTypeId(int typeId);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblProductType> findProductTypeWithParentId(int typeId);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblProductType> findProductTypeWithParentIdRecursive(int typeId);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblProductType> findProductTypeByOrgId(int orgId);
	
	public abstract void delete(int typeId);
	
	
	
}
