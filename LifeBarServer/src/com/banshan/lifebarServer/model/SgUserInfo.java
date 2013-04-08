package com.banshan.lifebarServer.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SgUserInfo entity. @author MyEclipse Persistence Tools
 */

public class SgUserInfo implements java.io.Serializable {

	// Fields

	private Long userId;
	private SgUserGroup sgUserGroup;
	private SgDepartmentInfo sgDepartmentInfo;
	private String userName;
	private String userPhone;
	private String userPassword;
	private Integer userStatus;
	private String userEmail;
	private String userPhoto;
	private Set sgUserCategories = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgUserInfo() {
	}

	/** minimal constructor */
	public SgUserInfo(String userName, String userPhone, String userPassword,
			Integer userStatus, String userEmail, String userPhoto) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
		this.userEmail = userEmail;
		this.userPhoto = userPhoto;
	}

	/** full constructor */
	public SgUserInfo(SgUserGroup sgUserGroup,
			SgDepartmentInfo sgDepartmentInfo, String userName,
			String userPhone, String userPassword, Integer userStatus,
			String userEmail, String userPhoto, Set sgUserCategories) {
		this.sgUserGroup = sgUserGroup;
		this.sgDepartmentInfo = sgDepartmentInfo;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
		this.userEmail = userEmail;
		this.userPhoto = userPhoto;
		this.sgUserCategories = sgUserCategories;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public SgUserGroup getSgUserGroup() {
		return this.sgUserGroup;
	}

	public void setSgUserGroup(SgUserGroup sgUserGroup) {
		this.sgUserGroup = sgUserGroup;
	}

	public SgDepartmentInfo getSgDepartmentInfo() {
		return this.sgDepartmentInfo;
	}

	public void setSgDepartmentInfo(SgDepartmentInfo sgDepartmentInfo) {
		this.sgDepartmentInfo = sgDepartmentInfo;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Set getSgUserCategories() {
		return this.sgUserCategories;
	}

	public void setSgUserCategories(Set sgUserCategories) {
		this.sgUserCategories = sgUserCategories;
	}

}