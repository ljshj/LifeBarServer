package com.banshan.lifebarServer.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.common.LifeBarDefination;
import com.banshan.lifebarServer.model.TblCompany;
import com.banshan.lifebarServer.model.TblPic;
import com.banshan.lifebarServer.model.TblProduct;
import com.banshan.lifebarServer.model.TblProductType;
import com.banshan.lifebarServer.model.TblTypeOfProduct;
import com.banshan.lifebarServer.model.TblUser;
import com.banshan.lifebarServer.service.OrgInfoService;
import com.banshan.lifebarServer.service.PicInfoService;
@Transactional
public class OrgInfoServiceImpl implements OrgInfoService {

	@Resource private SessionFactory sessionFactory;
	@Resource private PicInfoService picInfoService;

	@Override
	public void save(TblCompany t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblCompany.class, (int)Id));
		
		List<TblPic> picList = picInfoService.findPicsByRefIdAndRefType(Id, LifeBarDefination.LB_PIC_TYPE_ORG);
		for (TblPic pic : picList)
		{
			sessionFactory.getCurrentSession().delete(pic);
		}
	}

	@Override
	public void update(TblCompany t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblCompany findById(long Id) {
		return (TblCompany) sessionFactory.getCurrentSession().get(TblCompany.class, Id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblCompany> findAll(int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblCompany").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public TblCompany findOrgByAccount(String account) {
		String sql="from TblCompany where account='"+account+"'";
		return (TblCompany) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblCompany> findSubOrgsByOrgId(int orgId)
	{
		return sessionFactory.getCurrentSession().createQuery("from TblCompany where parent='" + orgId + "'").list();

	}

	@Override
	public List<TblCompany> findSubOrgsByOrgIdRecursive(int orgId)
	{
		List<TblCompany> result = findSubOrgsByOrgId(orgId);
		List<TblCompany> resultTmp = new ArrayList<TblCompany>();
		resultTmp.addAll(result);
		for (TblCompany org : resultTmp)
		{
			List<TblCompany> subResult = findSubOrgsByOrgIdRecursive(org.getCompanyId());
			result.addAll(subResult);
		}
		return result;
	}
}
