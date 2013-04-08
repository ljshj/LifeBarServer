package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.SgPagerInfo;
import com.banshan.lifebarServer.service.BaseService;
import com.banshan.lifebarServer.service.SgPagerInfoService;

@Transactional
public class SgPagerInfoServiceImpl implements BaseService<SgPagerInfo>,SgPagerInfoService {

	@Resource private SessionFactory sessionFactory;
	public void delete(long pagerId){
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(SgPagerInfo.class, pagerId));
	}
	
	@Transactional (propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public SgPagerInfo findById(long pagerId){
		return (SgPagerInfo) sessionFactory.getCurrentSession().get(SgPagerInfo.class, pagerId);
	}
	
	@Transactional (propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	@SuppressWarnings("unchecked")
	public List findAll(int offset,int pagesize){
		return sessionFactory.getCurrentSession().createQuery("from SgPagerInfo").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public void save(SgPagerInfo sgPagerInfo) {
		sessionFactory.getCurrentSession().persist(sgPagerInfo);
	}

	@Override
	public void update(SgPagerInfo sgPagerInfo) {
		sessionFactory.getCurrentSession().merge(sgPagerInfo);
	}

	@SuppressWarnings("unchecked")
	@Transactional (propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<SgPagerInfo> findByParentId(long pagerId) {
		return sessionFactory.getCurrentSession().createQuery("from SgPagerInfo where parentId="+pagerId).list();
	}
	
}
