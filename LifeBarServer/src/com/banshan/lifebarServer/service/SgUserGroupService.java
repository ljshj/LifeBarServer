package com.banshan.lifebarServer.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banshan.lifebarServer.model.SgUserGroup;

public interface SgUserGroupService {

	public abstract void save(SgUserGroup sgUserGroup);

	public abstract void delete(long groupId);

	public abstract void update(SgUserGroup sgUserGroup);

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract SgUserGroup findByGroupId(long groupId);

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public abstract List<SgUserGroup> findAll(int offset, int pagesize);

}