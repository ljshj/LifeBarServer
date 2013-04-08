package com.banshan.lifebarServer.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SgCategoryInfo entity. @author MyEclipse Persistence Tools
 */

public class SgCategoryInfo implements java.io.Serializable {

	// Fields

	private Long categoryId;
	private SgCompanyInfo sgCompanyInfo;
	private String categoryName;
	private Long categoryParent;
	private Boolean categoryIsLeaf;
	private Integer categoryStatus;
	private String categoryRemark;
	
	private Set sgUserCategories = new HashSet(0);
	private Set sgQuestionInfos = new HashSet(0);
	private Set sgMaterialInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgCategoryInfo() {
	}

	/** minimal constructor */
	public SgCategoryInfo(String categoryName, Boolean categoryIsLeaf,
			Integer categoryStatus) {
		this.categoryName = categoryName;
		this.categoryIsLeaf = categoryIsLeaf;
		this.categoryStatus = categoryStatus;
	}

	/** full constructor */
	public SgCategoryInfo(SgCompanyInfo sgCompanyInfo, String categoryName,
			Long categoryParent, Boolean categoryIsLeaf,
			Integer categoryStatus, String categoryRemark,
			Set sgUserCategories, Set sgQuestionInfos, Set sgMaterialInfos) {
		this.sgCompanyInfo = sgCompanyInfo;
		this.categoryName = categoryName;
		this.categoryParent = categoryParent;
		this.categoryIsLeaf = categoryIsLeaf;
		this.categoryStatus = categoryStatus;
		this.categoryRemark = categoryRemark;
		this.sgUserCategories = sgUserCategories;
		this.sgQuestionInfos = sgQuestionInfos;
		this.sgMaterialInfos = sgMaterialInfos;
	}

	// Property accessors

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public SgCompanyInfo getSgCompanyInfo() {
		return this.sgCompanyInfo;
	}

	public void setSgCompanyInfo(SgCompanyInfo sgCompanyInfo) {
		this.sgCompanyInfo = sgCompanyInfo;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getCategoryParent() {
		return this.categoryParent;
	}

	public void setCategoryParent(Long categoryParent) {
		this.categoryParent = categoryParent;
	}

	public Boolean getCategoryIsLeaf() {
		return this.categoryIsLeaf;
	}

	public void setCategoryIsLeaf(Boolean categoryIsLeaf) {
		this.categoryIsLeaf = categoryIsLeaf;
	}

	public Integer getCategoryStatus() {
		return this.categoryStatus;
	}

	public void setCategoryStatus(Integer categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getCategoryRemark() {
		return this.categoryRemark;
	}

	public void setCategoryRemark(String categoryRemark) {
		this.categoryRemark = categoryRemark;
	}

	public Set getSgUserCategories() {
		return this.sgUserCategories;
	}

	public void setSgUserCategories(Set sgUserCategories) {
		this.sgUserCategories = sgUserCategories;
	}

	public Set getSgQuestionInfos() {
		return this.sgQuestionInfos;
	}

	public void setSgQuestionInfos(Set sgQuestionInfos) {
		this.sgQuestionInfos = sgQuestionInfos;
	}

	public Set getSgMaterialInfos() {
		return this.sgMaterialInfos;
	}

	public void setSgMaterialInfos(Set sgMaterialInfos) {
		this.sgMaterialInfos = sgMaterialInfos;
	}

}