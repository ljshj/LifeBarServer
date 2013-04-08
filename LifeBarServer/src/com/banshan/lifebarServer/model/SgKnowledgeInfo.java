package com.banshan.lifebarServer.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgKnowledgeInfo entity. @author MyEclipse Persistence Tools
 */

public class SgKnowledgeInfo implements java.io.Serializable {

	// Fields

	private Long knowledgeId;
	private Long categoryId;
	private String knowledgeName;
	private String knowledgeContent;
	private Date knowledgeCreateTime;
	private Long knowledgeCreater;
	private String knowledgeRemark;
	private Set sgMaterialKnowledges = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgKnowledgeInfo() {
	}

	/** minimal constructor */
	public SgKnowledgeInfo(String knowledgeName, String knowledgeContent,
			Date knowledgeCreateTime) {
		this.knowledgeName = knowledgeName;
		this.knowledgeContent = knowledgeContent;
		this.knowledgeCreateTime = knowledgeCreateTime;
	}

	/** full constructor */
	public SgKnowledgeInfo(Long categoryId, String knowledgeName,
			String knowledgeContent, Date knowledgeCreateTime,
			Long knowledgeCreater, String knowledgeRemark,
			Set sgMaterialKnowledges) {
		this.categoryId = categoryId;
		this.knowledgeName = knowledgeName;
		this.knowledgeContent = knowledgeContent;
		this.knowledgeCreateTime = knowledgeCreateTime;
		this.knowledgeCreater = knowledgeCreater;
		this.knowledgeRemark = knowledgeRemark;
		this.sgMaterialKnowledges = sgMaterialKnowledges;
	}

	// Property accessors

	public Long getKnowledgeId() {
		return this.knowledgeId;
	}

	public void setKnowledgeId(Long knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getKnowledgeName() {
		return this.knowledgeName;
	}

	public void setKnowledgeName(String knowledgeName) {
		this.knowledgeName = knowledgeName;
	}

	public String getKnowledgeContent() {
		return this.knowledgeContent;
	}

	public void setKnowledgeContent(String knowledgeContent) {
		this.knowledgeContent = knowledgeContent;
	}

	public Date getKnowledgeCreateTime() {
		return this.knowledgeCreateTime;
	}

	public void setKnowledgeCreateTime(Date knowledgeCreateTime) {
		this.knowledgeCreateTime = knowledgeCreateTime;
	}

	public Long getKnowledgeCreater() {
		return this.knowledgeCreater;
	}

	public void setKnowledgeCreater(Long knowledgeCreater) {
		this.knowledgeCreater = knowledgeCreater;
	}

	public String getKnowledgeRemark() {
		return this.knowledgeRemark;
	}

	public void setKnowledgeRemark(String knowledgeRemark) {
		this.knowledgeRemark = knowledgeRemark;
	}

	public Set getSgMaterialKnowledges() {
		return this.sgMaterialKnowledges;
	}

	public void setSgMaterialKnowledges(Set sgMaterialKnowledges) {
		this.sgMaterialKnowledges = sgMaterialKnowledges;
	}

}