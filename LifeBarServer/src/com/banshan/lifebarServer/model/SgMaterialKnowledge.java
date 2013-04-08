package com.banshan.lifebarServer.model;

/**
 * SgMaterialKnowledge entity. @author MyEclipse Persistence Tools
 */

public class SgMaterialKnowledge implements java.io.Serializable {

	// Fields

	private Long materialKnowledgeId;
	private SgKnowledgeInfo sgKnowledgeInfo;
	private SgMaterialInfo sgMaterialInfo;

	// Constructors

	/** default constructor */
	public SgMaterialKnowledge() {
	}

	/** full constructor */
	public SgMaterialKnowledge(SgKnowledgeInfo sgKnowledgeInfo,
			SgMaterialInfo sgMaterialInfo) {
		this.sgKnowledgeInfo = sgKnowledgeInfo;
		this.sgMaterialInfo = sgMaterialInfo;
	}

	// Property accessors

	public Long getMaterialKnowledgeId() {
		return this.materialKnowledgeId;
	}

	public void setMaterialKnowledgeId(Long materialKnowledgeId) {
		this.materialKnowledgeId = materialKnowledgeId;
	}

	public SgKnowledgeInfo getSgKnowledgeInfo() {
		return this.sgKnowledgeInfo;
	}

	public void setSgKnowledgeInfo(SgKnowledgeInfo sgKnowledgeInfo) {
		this.sgKnowledgeInfo = sgKnowledgeInfo;
	}

	public SgMaterialInfo getSgMaterialInfo() {
		return this.sgMaterialInfo;
	}

	public void setSgMaterialInfo(SgMaterialInfo sgMaterialInfo) {
		this.sgMaterialInfo = sgMaterialInfo;
	}

}