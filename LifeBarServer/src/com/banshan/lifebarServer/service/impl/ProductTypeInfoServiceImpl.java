package com.banshan.lifebarServer.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblProductType;
import com.banshan.lifebarServer.model.TblProductType;
import com.banshan.lifebarServer.service.ProductTypeInfoService;
@Transactional
public class ProductTypeInfoServiceImpl implements ProductTypeInfoService
{

	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void save(TblProductType t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblProductType.class, (int)Id));
	}

	@Override
	public void update(TblProductType t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblProductType findById(long Id) {
		return (TblProductType) sessionFactory.getCurrentSession().get(TblProductType.class, Id);
	}

	@Override
	public List<TblProductType> findAll(int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblProductType").setFirstResult(offset).setMaxResults(pagesize).list();
	}


	@Override
	public TblProductType findProductTypeParentByTypeId(int typeId)
	{
		//select * from tbl_producttype where typeId =(select parent from tbl_producttype where typeId='5')
		String sql="from TblProductType where typeId=(select parent from tbl_producttype where typeId='"+typeId+"')";
		return (TblProductType) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
		
	}

	@Override
	public List<TblProductType> findProductTypeWithParentId(int typeId)
	{
		return sessionFactory.getCurrentSession().createQuery("from TblProductType where parent='" + typeId + "'").list();
	}

	@Override
	public List<TblProductType> findProductTypeWithParentIdRecursive(
			int typeId)
	{
		List<TblProductType> result = findProductTypeWithParentId(typeId);
		List<TblProductType> resultTmp = new ArrayList<TblProductType>();
		resultTmp.addAll(result);
		for (TblProductType type : resultTmp)
		{
			List<TblProductType> subResult = findProductTypeWithParentIdRecursive(type.getTypeId());
			result.addAll(subResult);
		}
		return result;
	}

	@Override
	public List<TblProductType> findProductTypeByOrgId(int orgId)
	{
		return sessionFactory.getCurrentSession().createQuery("from TblProductType where orgId='" + orgId + "'").list();
	}

	@Override
	public void delete(int typeId)
	{
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblProductType.class, typeId));
	}

	
}
