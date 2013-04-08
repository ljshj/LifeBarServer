package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblCompanyConf;
import com.banshan.lifebarServer.service.OrgConfService;

@Transactional
public class OrgConfServiceImpl implements OrgConfService
{

@Resource private SessionFactory sessionFactory;
	
	@Override
	public void save(TblCompanyConf t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblCompanyConf.class, Id));
	}

	@Override
	public void update(TblCompanyConf t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblCompanyConf findById(long Id) {
		return (TblCompanyConf) sessionFactory.getCurrentSession().get(TblCompanyConf.class, Id);
	}

	@Override
	public List<TblCompanyConf> findAll(int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblCompanyConf").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public List<TblCompanyConf> findConfByOrgId(int orgId)
	{
		return sessionFactory.getCurrentSession().createQuery("from TblCompanyConf where companyId='" + orgId + "'").list();
	}

	@Override
	public void update(int orgId, String key, String value)
	{
		TblCompanyConf conf = (TblCompanyConf) sessionFactory.getCurrentSession().createQuery("from TblCompanyConf where companyId='" + orgId + "' and name='" + key + "'").uniqueResult();
		conf.setValue(value);
		this.update(conf);
	}

}
