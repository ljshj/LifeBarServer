package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.SgUserGroup;
import com.banshan.lifebarServer.service.BaseService;

@Transactional
public class SgUserGroupServiceImpl implements BaseService<SgUserGroup> {

	@Resource private SessionFactory sessionFactory;
	public void save(SgUserGroup sgUserGroup){
		sessionFactory.getCurrentSession().persist(sgUserGroup);
	}
	
	public void delete(long groupId){
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(SgUserGroup.class, groupId));
	}
	
	public void update(SgUserGroup sgUserGroup){
		sessionFactory.getCurrentSession().merge(sgUserGroup);
	}
	
	@Transactional (propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public SgUserGroup findById(long groupId){
		return (SgUserGroup) sessionFactory.getCurrentSession().get(SgUserGroup.class, groupId);
	}
	
	@Transactional (propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	@SuppressWarnings("unchecked")
	public List<SgUserGroup> findAll(int offset,int pagesize){
		return sessionFactory.getCurrentSession().createQuery("from SgUserGroup").setFirstResult(offset).setMaxResults(pagesize).list();
	}
}
