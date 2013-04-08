package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.SgUserInfo;
import com.banshan.lifebarServer.service.BaseService;
import com.banshan.lifebarServer.service.SgUserInfoService;

@Transactional
public class SgUserInfoServiceImpl implements BaseService<SgUserInfo>,SgUserInfoService {

	@Resource private SessionFactory sessionFactory;

	@Override
	public void delete(long userId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(SgUserInfo.class, userId));
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<SgUserInfo> findAll(int offset, int pagesize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from SgUserInfo").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public SgUserInfo findById(long userId) {
		return (SgUserInfo) sessionFactory.getCurrentSession().get(SgUserInfo.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SgUserInfo> findByUserPhone(String userPhone) {
		String sql="from SgUserInfo where userPhone='"+userPhone+"'";
		System.out.println(userPhone);
		return sessionFactory.getCurrentSession().createQuery(sql).list();
	}

	@Override
	public void save(SgUserInfo sgUserInfo) {
		sessionFactory.getCurrentSession().persist(sgUserInfo);
	}

	@Override
	public void update(SgUserInfo sgUserInfo) {
		sessionFactory.getCurrentSession().merge(sgUserInfo);
	}
	
	
	
}
