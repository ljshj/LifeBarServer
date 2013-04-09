package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.common.LifeBarDefination;
import com.banshan.lifebarServer.model.TblPic;
import com.banshan.lifebarServer.model.TblProduct;
import com.banshan.lifebarServer.model.TblProductType;
import com.banshan.lifebarServer.model.TblTypeOfProduct;
import com.banshan.lifebarServer.service.PicInfoService;
import com.banshan.lifebarServer.service.ProductInfoService;
import com.banshan.lifebarServer.service.ProductTypeInfoService;
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService {

	@Resource private SessionFactory sessionFactory;
	@Resource private ProductTypeInfoService productTypeInfoService;
	@Resource private PicInfoService picInfoService;

	@Override
	public void save(TblProduct t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblProduct.class, Id));
		List<TblTypeOfProduct> typeList = findAllTypesWithProductId(Id);
		for (TblTypeOfProduct type : typeList)
		{
			sessionFactory.getCurrentSession().delete(type);
		}
		List<TblPic> picList = picInfoService.findPicsByRefIdAndRefType(Id, LifeBarDefination.LB_PIC_TYPE_PRODUCT);
		for (TblPic pic : picList)
		{
			sessionFactory.getCurrentSession().delete(pic);
		}
	}

	@Override
	public void update(TblProduct t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblProduct findById(long Id) {
		return (TblProduct) sessionFactory.getCurrentSession().get(TblProduct.class, Id);
	}

	@Override
	public List<TblProduct> findAll(int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblProduct").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public List<TblProduct> findProductsByOrgId(int Id, int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblProduct where orgid='" + Id + "'").setFirstResult(offset).setMaxResults(pagesize).list();

	}

	@Override
	public List<TblProduct> findProductsByOrgIdWithTypeId(int Id, int typeId,
			int offset, int pagesize)
	{
		List<TblProductType> types = productTypeInfoService.findProductTypeWithParentIdRecursive(typeId);
		String typesStr = String.valueOf(typeId) + ",";
		for (TblProductType type : types)
		{
			typesStr += String.valueOf(typeId) + ",";
		}
		typesStr = typesStr.substring(0, typesStr.length() - 1);	
		return sessionFactory.getCurrentSession().createQuery("from TblProduct where orgid='" + Id + "' and productId in (select productId from TblTypeOfProduct where typeId in (" + typesStr + "))").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public void addProductToType(long productId, int typeId)
	{
		TblTypeOfProduct tp = new TblTypeOfProduct();
		tp.setProductId(productId);
		tp.setTypeId(typeId);
		sessionFactory.getCurrentSession().persist(tp);
	}

	@Override
	public void dropTypeFromProduct(long productId, int typeId)
	{
		List<TblTypeOfProduct> tmpList = (List<TblTypeOfProduct>) sessionFactory.getCurrentSession().createQuery("from TblTypeOfProduct where productId='" + productId + "' and typeId='" + typeId + "'").list();
		for (TblTypeOfProduct type : tmpList)
		{
			sessionFactory.getCurrentSession().delete(type);
		}
	}

	@Override
	public List<TblTypeOfProduct> findAllTypesWithProductId(long productId)
	{
		return sessionFactory.getCurrentSession().createQuery("from TblTypeOfProduct where productId='" + productId + "'").list();
	}

}
