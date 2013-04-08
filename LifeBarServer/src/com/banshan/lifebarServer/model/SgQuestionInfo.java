package com.banshan.lifebarServer.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgQuestionInfo entity. @author MyEclipse Persistence Tools
 */

public class SgQuestionInfo implements java.io.Serializable {

	// Fields

	private Long questionId;
	private SgCategoryInfo sgCategoryInfo;
	private String questionName;
	private String questionContent;
	private String questionKey;
	private Date questionCreateTime;
	private Long questionCreater;
	private String questionRemark;
	private Set sgPaperQuestions = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgQuestionInfo() {
	}

	/** minimal constructor */
	public SgQuestionInfo(String questionName, String questionContent,
			String questionKey, Date questionCreateTime,
			Long questionCreater) {
		this.questionName = questionName;
		this.questionContent = questionContent;
		this.questionKey = questionKey;
		this.questionCreateTime = questionCreateTime;
		this.questionCreater = questionCreater;
	}

	/** full constructor */
	public SgQuestionInfo(SgCategoryInfo sgCategoryInfo, String questionName,
			String questionContent, String questionKey,
			Date questionCreateTime, Long questionCreater,
			String questionRemark, Set sgPaperQuestions) {
		this.sgCategoryInfo = sgCategoryInfo;
		this.questionName = questionName;
		this.questionContent = questionContent;
		this.questionKey = questionKey;
		this.questionCreateTime = questionCreateTime;
		this.questionCreater = questionCreater;
		this.questionRemark = questionRemark;
		this.sgPaperQuestions = sgPaperQuestions;
	}

	// Property accessors

	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public SgCategoryInfo getSgCategoryInfo() {
		return this.sgCategoryInfo;
	}

	public void setSgCategoryInfo(SgCategoryInfo sgCategoryInfo) {
		this.sgCategoryInfo = sgCategoryInfo;
	}

	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionKey() {
		return this.questionKey;
	}

	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}

	public Date getQuestionCreateTime() {
		return this.questionCreateTime;
	}

	public void setQuestionCreateTime(Date questionCreateTime) {
		this.questionCreateTime = questionCreateTime;
	}

	public Long getQuestionCreater() {
		return this.questionCreater;
	}

	public void setQuestionCreater(Long questionCreater) {
		this.questionCreater = questionCreater;
	}

	public String getQuestionRemark() {
		return this.questionRemark;
	}

	public void setQuestionRemark(String questionRemark) {
		this.questionRemark = questionRemark;
	}

	public Set getSgPaperQuestions() {
		return this.sgPaperQuestions;
	}

	public void setSgPaperQuestions(Set sgPaperQuestions) {
		this.sgPaperQuestions = sgPaperQuestions;
	}

}