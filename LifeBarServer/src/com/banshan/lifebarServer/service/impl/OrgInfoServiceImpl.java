package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblCompany;
import com.banshan.lifebarServer.model.TblUser;
import com.banshan.lifebarServer.service.OrgInfoService;
@Transactional
public class OrgInfoServiceImpl implements OrgInfoService {

	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void save(TblCompany t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblCompany.class, Id));
	}

	@Override
	public void update(TblCompany t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblCompany findById(long Id) {
		return (TblCompany) sessionFactory.getCurrentSession().get(TblCompany.class, Id);
	}

	@Override
	public List<TblCompany> findAll(int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblCompany").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public TblCompany findOrgByAccount(String account) {
		String sql="from TblCompany where account='"+account+"'";
		return (TblCompany) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
	}
}
