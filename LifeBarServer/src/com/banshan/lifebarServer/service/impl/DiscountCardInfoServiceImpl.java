package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblDiscountcard;
import com.banshan.lifebarServer.service.DiscountCardInfoService;
@Transactional
public class DiscountCardInfoServiceImpl implements DiscountCardInfoService {

	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void save(TblDiscountcard t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblDiscountcard.class, Id));
	}

	@Override
	public void update(TblDiscountcard t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblDiscountcard findById(long Id) {
		return (TblDiscountcard) sessionFactory.getCurrentSession().get(TblDiscountcard.class, Id);
	}

	@Override
	public List<TblDiscountcard> findAll(int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblDiscountcard").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public List<TblDiscountcard> findCardByOrgId(int Id, int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblDiscountcard where orgId='" + Id +"'").setFirstResult(offset).setMaxResults(pagesize).list();

	}
}
