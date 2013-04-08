package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface BaseService<T> {

	public abstract void save(T t);

	public abstract void delete(long Id);

	public abstract void update(T t);

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract T findById(long Id);

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<T> findAll(int offset, int pagesize);

}