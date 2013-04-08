package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblUser;
import com.banshan.lifebarServer.service.UserInfoService;
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void save(TblUser t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblUser.class, Id));
	}

	@Override
	public void update(TblUser t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblUser findById(long Id) {
		return (TblUser) sessionFactory.getCurrentSession().get(TblUser.class, Id);
	}

	@Override
	public List<TblUser> findAll(int offset, int pagesize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from TblUser").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public TblUser findUserByAccount(String account) {
		String sql="from TblUser where account='"+account+"'";
		return (TblUser) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
	}

}
