package com.banshan.lifebarServer.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SgDepartmentInfo entity. @author MyEclipse Persistence Tools
 */

public class SgDepartmentInfo implements java.io.Serializable {

	// Fields

	private Long departmentId;
	private Long districtId;
	private String departmentName;
	private String departmentRemark;
	private Set sgUserInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgDepartmentInfo() {
	}

	/** minimal constructor */
	public SgDepartmentInfo(String departmentName) {
		this.departmentName = departmentName;
	}

	/** full constructor */
	public SgDepartmentInfo(Long districtId, String departmentName,
			String departmentRemark, Set sgUserInfos) {
		this.districtId = districtId;
		this.departmentName = departmentName;
		this.departmentRemark = departmentRemark;
		this.sgUserInfos = sgUserInfos;
	}

	// Property accessors

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentRemark() {
		return this.departmentRemark;
	}

	public void setDepartmentRemark(String departmentRemark) {
		this.departmentRemark = departmentRemark;
	}

	public Set getSgUserInfos() {
		return this.sgUserInfos;
	}

	public void setSgUserInfos(Set sgUserInfos) {
		this.sgUserInfos = sgUserInfos;
	}

}