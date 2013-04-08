package com.banshan.lifebarServer.model;

/**
 * SgPaperQuestion entity. @author MyEclipse Persistence Tools
 */

public class SgPaperQuestion implements java.io.Serializable {

	// Fields

	private Long paperQuestionId;
	private SgQuestionInfo sgQuestionInfo;
	private SgPaperInfo sgPaperInfo;

	// Constructors

	/** default constructor */
	public SgPaperQuestion() {
	}

	/** full constructor */
	public SgPaperQuestion(SgQuestionInfo sgQuestionInfo,
			SgPaperInfo sgPaperInfo) {
		this.sgQuestionInfo = sgQuestionInfo;
		this.sgPaperInfo = sgPaperInfo;
	}

	// Property accessors

	public Long getPaperQuestionId() {
		return this.paperQuestionId;
	}

	public void setPaperQuestionId(Long paperQuestionId) {
		this.paperQuestionId = paperQuestionId;
	}

	public SgQuestionInfo getSgQuestionInfo() {
		return this.sgQuestionInfo;
	}

	public void setSgQuestionInfo(SgQuestionInfo sgQuestionInfo) {
		this.sgQuestionInfo = sgQuestionInfo;
	}

	public SgPaperInfo getSgPaperInfo() {
		return this.sgPaperInfo;
	}

	public void setSgPaperInfo(SgPaperInfo sgPaperInfo) {
		this.sgPaperInfo = sgPaperInfo;
	}

}