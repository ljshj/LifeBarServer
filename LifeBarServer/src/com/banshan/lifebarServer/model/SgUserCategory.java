package com.banshan.lifebarServer.model;

/**
 * SgUserCategory entity. @author MyEclipse Persistence Tools
 */

public class SgUserCategory implements java.io.Serializable {

	// Fields

	private Long userCategoryId;
	private SgUserInfo sgUserInfo;
	private SgCategoryInfo sgCategoryInfo;

	// Constructors

	/** default constructor */
	public SgUserCategory() {
	}

	/** full constructor */
	public SgUserCategory(SgUserInfo sgUserInfo, SgCategoryInfo sgCategoryInfo) {
		this.sgUserInfo = sgUserInfo;
		this.sgCategoryInfo = sgCategoryInfo;
	}

	// Property accessors

	public Long getUserCategoryId() {
		return this.userCategoryId;
	}

	public void setUserCategoryId(Long userCategoryId) {
		this.userCategoryId = userCategoryId;
	}

	public SgUserInfo getSgUserInfo() {
		return this.sgUserInfo;
	}

	public void setSgUserInfo(SgUserInfo sgUserInfo) {
		this.sgUserInfo = sgUserInfo;
	}

	public SgCategoryInfo getSgCategoryInfo() {
		return this.sgCategoryInfo;
	}

	public void setSgCategoryInfo(SgCategoryInfo sgCategoryInfo) {
		this.sgCategoryInfo = sgCategoryInfo;
	}

}