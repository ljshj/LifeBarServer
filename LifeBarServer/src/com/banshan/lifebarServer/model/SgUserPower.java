package com.banshan.lifebarServer.model;

/**
 * SgUserPower entity. @author MyEclipse Persistence Tools
 */

public class SgUserPower implements java.io.Serializable {

	// Fields

	private Long powerId;
	private SgPagerInfo sgPagerInfo;
	private SgUserGroup sgUserGroup;

	// Constructors

	/** default constructor */
	public SgUserPower() {
	}

	/** full constructor */
	public SgUserPower(SgPagerInfo sgPagerInfo, SgUserGroup sgUserGroup) {
		this.sgPagerInfo = sgPagerInfo;
		this.sgUserGroup = sgUserGroup;
	}

	// Property accessors

	public Long getPowerId() {
		return this.powerId;
	}

	public void setPowerId(Long powerId) {
		this.powerId = powerId;
	}

	public SgPagerInfo getSgPagerInfo() {
		return this.sgPagerInfo;
	}

	public void setSgPagerInfo(SgPagerInfo sgPagerInfo) {
		this.sgPagerInfo = sgPagerInfo;
	}

	public SgUserGroup getSgUserGroup() {
		return this.sgUserGroup;
	}

	public void setSgUserGroup(SgUserGroup sgUserGroup) {
		this.sgUserGroup = sgUserGroup;
	}

}