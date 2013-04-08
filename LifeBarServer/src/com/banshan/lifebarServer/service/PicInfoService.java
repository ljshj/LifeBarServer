package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.TblPic;

public interface PicInfoService extends BaseService<TblPic>{

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract TblPic findPicByRefIdAndRefTypeAndType(long Id, short reftype, short type);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<TblPic> findPicsByRefIdAndRefType(long Id, short reftype);
}
