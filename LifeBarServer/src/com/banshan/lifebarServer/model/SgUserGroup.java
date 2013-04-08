package com.banshan.lifebarServer.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgUserGroup entity. @author MyEclipse Persistence Tools
 */

public class SgUserGroup implements java.io.Serializable {

	// Fields

	private Long groupId;
	private String groupName;
	private Date groupCreateTime;
	private String groupRemark;
	private Set sgUserInfos = new HashSet(0);
	private Set sgUserPowers = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgUserGroup() {
	}

	/** minimal constructor */
	public SgUserGroup(String groupName, Date groupCreateTime,
			String groupRemark) {
		this.groupName = groupName;
		this.groupCreateTime = groupCreateTime;
		this.groupRemark = groupRemark;
	}

	/** full constructor */
	public SgUserGroup(String groupName, Date groupCreateTime,
			String groupRemark, Set sgUserInfos, Set sgUserPowers) {
		this.groupName = groupName;
		this.groupCreateTime = groupCreateTime;
		this.groupRemark = groupRemark;
		this.sgUserInfos = sgUserInfos;
		this.sgUserPowers = sgUserPowers;
	}

	// Property accessors

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getGroupCreateTime() {
		return this.groupCreateTime;
	}

	public void setGroupCreateTime(Date groupCreateTime) {
		this.groupCreateTime = groupCreateTime;
	}

	public String getGroupRemark() {
		return this.groupRemark;
	}

	public void setGroupRemark(String groupRemark) {
		this.groupRemark = groupRemark;
	}

	public Set getSgUserInfos() {
		return this.sgUserInfos;
	}

	public void setSgUserInfos(Set sgUserInfos) {
		this.sgUserInfos = sgUserInfos;
	}

	public Set getSgUserPowers() {
		return this.sgUserPowers;
	}

	public void setSgUserPowers(Set sgUserPowers) {
		this.sgUserPowers = sgUserPowers;
	}

}