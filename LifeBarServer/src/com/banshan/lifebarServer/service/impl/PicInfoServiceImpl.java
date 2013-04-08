package com.banshan.lifebarServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.common.LifeBarDefination;
import com.banshan.lifebarServer.model.TblPic;
import com.banshan.lifebarServer.model.TblPic;
import com.banshan.lifebarServer.service.PicInfoService;
@Transactional
public class PicInfoServiceImpl implements PicInfoService {

	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void save(TblPic t) {
		sessionFactory.getCurrentSession().persist(t);
	}

	@Override
	public void delete(long Id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(TblPic.class, Id));
	}

	@Override
	public void update(TblPic t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	@Override
	public TblPic findById(long Id) {
		return (TblPic) sessionFactory.getCurrentSession().get(TblPic.class, Id);
	}

	@Override
	public List<TblPic> findAll(int offset, int pagesize) {
		return sessionFactory.getCurrentSession().createQuery("from TblPic").setFirstResult(offset).setMaxResults(pagesize).list();
	}

	@Override
	public TblPic findPicByRefIdAndRefTypeAndType(long Id, short reftype, short type) {
		String sql="from TblPic where refId='"+Id + "' and refType='" + reftype + "' and type='" + type + "'" ;
		return (TblPic) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
	}

	@Override
	public List<TblPic> findPicsByRefIdAndRefType(long Id, short reftype) {
		return sessionFactory.getCurrentSession().createQuery("from TblPic where refId='"+Id + "' and refType='" + reftype + "'").setFirstResult(0).setMaxResults(LifeBarDefination.LB_MAX_PRODUCT_PIC_NUM).list();

	}

}
