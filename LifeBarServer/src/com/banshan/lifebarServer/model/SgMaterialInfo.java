package com.banshan.lifebarServer.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgMaterialInfo entity. @author MyEclipse Persistence Tools
 */

public class SgMaterialInfo implements java.io.Serializable {

	// Fields

	private Long materialId;
	private SgCategoryInfo sgCategoryInfo;
	private String materialName;
	private Date materialCreateTime;
	private Long materialCreater;
	private String materialRemark;
	private Set sgMaterialKnowledges = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgMaterialInfo() {
	}

	/** minimal constructor */
	public SgMaterialInfo(String materialName, Date materialCreateTime,
			Long materialCreater) {
		this.materialName = materialName;
		this.materialCreateTime = materialCreateTime;
		this.materialCreater = materialCreater;
	}

	/** full constructor */
	public SgMaterialInfo(SgCategoryInfo sgCategoryInfo, String materialName,
			Date materialCreateTime, Long materialCreater,
			String materialRemark, Set sgMaterialKnowledges) {
		this.sgCategoryInfo = sgCategoryInfo;
		this.materialName = materialName;
		this.materialCreateTime = materialCreateTime;
		this.materialCreater = materialCreater;
		this.materialRemark = materialRemark;
		this.sgMaterialKnowledges = sgMaterialKnowledges;
	}

	// Property accessors

	public Long getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public SgCategoryInfo getSgCategoryInfo() {
		return this.sgCategoryInfo;
	}

	public void setSgCategoryInfo(SgCategoryInfo sgCategoryInfo) {
		this.sgCategoryInfo = sgCategoryInfo;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Date getMaterialCreateTime() {
		return this.materialCreateTime;
	}

	public void setMaterialCreateTime(Date materialCreateTime) {
		this.materialCreateTime = materialCreateTime;
	}

	public Long getMaterialCreater() {
		return this.materialCreater;
	}

	public void setMaterialCreater(Long materialCreater) {
		this.materialCreater = materialCreater;
	}

	public String getMaterialRemark() {
		return this.materialRemark;
	}

	public void setMaterialRemark(String materialRemark) {
		this.materialRemark = materialRemark;
	}

	public Set getSgMaterialKnowledges() {
		return this.sgMaterialKnowledges;
	}

	public void setSgMaterialKnowledges(Set sgMaterialKnowledges) {
		this.sgMaterialKnowledges = sgMaterialKnowledges;
	}

}