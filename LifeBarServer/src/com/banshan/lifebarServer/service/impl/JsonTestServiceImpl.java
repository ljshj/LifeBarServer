package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.Gridext;
import com.banshan.lifebarServer.model.SgUserInfo;
import com.banshan.lifebarServer.service.BaseService;
import com.banshan.lifebarServer.service.JsonTestService;

@Transactional
public class JsonTestServiceImpl implements JsonTestService {

	@Resource private SessionFactory sessionFactory;

	@Override
	public void save(Gridext t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Gridext.class, Id));
	}

	@Override
	public void update(Gridext t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(t);
		
	}

	@Override
	public Gridext findById(long Id) {
		// TODO Auto-generated method stub
		return (Gridext) sessionFactory.getCurrentSession().get(Gridext.class, Id);
		 
	}

	@Override
	public List<Gridext> findAll(int offset, int pagesize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Gridext").setFirstResult(offset).setMaxResults(pagesize).list();
	}

}
