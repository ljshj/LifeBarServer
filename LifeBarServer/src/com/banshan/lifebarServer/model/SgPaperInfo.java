package com.banshan.lifebarServer.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgPaperInfo entity. @author MyEclipse Persistence Tools
 */

public class SgPaperInfo implements java.io.Serializable {

	// Fields

	private Long paperId;
	private Long categoryId;
	private String paperName;
	private Date paperCreateTime;
	private Long paperCreater;
	private String paperRemark;
	private Set sgPaperQuestions = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgPaperInfo() {
	}

	/** minimal constructor */
	public SgPaperInfo(String paperName, Date paperCreateTime,
			Long paperCreater) {
		this.paperName = paperName;
		this.paperCreateTime = paperCreateTime;
		this.paperCreater = paperCreater;
	}

	/** full constructor */
	public SgPaperInfo(Long categoryId, String paperName,
			Date paperCreateTime, Long paperCreater, String paperRemark,
			Set sgPaperQuestions) {
		this.categoryId = categoryId;
		this.paperName = paperName;
		this.paperCreateTime = paperCreateTime;
		this.paperCreater = paperCreater;
		this.paperRemark = paperRemark;
		this.sgPaperQuestions = sgPaperQuestions;
	}

	// Property accessors

	public Long getPaperId() {
		return this.paperId;
	}

	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getPaperName() {
		return this.paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public Date getPaperCreateTime() {
		return this.paperCreateTime;
	}

	public void setPaperCreateTime(Date paperCreateTime) {
		this.paperCreateTime = paperCreateTime;
	}

	public Long getPaperCreater() {
		return this.paperCreater;
	}

	public void setPaperCreater(Long paperCreater) {
		this.paperCreater = paperCreater;
	}

	public String getPaperRemark() {
		return this.paperRemark;
	}

	public void setPaperRemark(String paperRemark) {
		this.paperRemark = paperRemark;
	}

	public Set getSgPaperQuestions() {
		return this.sgPaperQuestions;
	}

	public void setSgPaperQuestions(Set sgPaperQuestions) {
		this.sgPaperQuestions = sgPaperQuestions;
	}

}