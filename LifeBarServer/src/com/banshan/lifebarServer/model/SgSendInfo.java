package com.banshan.lifebarServer.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SgSendInfo entity. @author MyEclipse Persistence Tools
 */

public class SgSendInfo implements java.io.Serializable {

	// Fields

	private Long sendId;
	private SgCompanyInfo sgCompanyInfo;
	private String sendName;
	private Long sendPaperQuestion;
	private Long sendTrainee;
	private Date sendStartTime;
	private Date sendEndTime;
	private Integer sendStatus;
	private Integer sendType;
	private Set sgReceiveInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgSendInfo() {
	}

	/** minimal constructor */
	public SgSendInfo(String sendName, Long sendPaperQuestion,
			Long sendTrainee, Date sendStartTime, Date sendEndTime,
			Integer sendStatus) {
		this.sendName = sendName;
		this.sendPaperQuestion = sendPaperQuestion;
		this.sendTrainee = sendTrainee;
		this.sendStartTime = sendStartTime;
		this.sendEndTime = sendEndTime;
		this.sendStatus = sendStatus;
	}

	/** full constructor */
	public SgSendInfo(SgCompanyInfo sgCompanyInfo, String sendName,
			Long sendPaperQuestion, Long sendTrainee, Date sendStartTime,
			Date sendEndTime, Integer sendStatus, Integer sendType,
			Set sgReceiveInfos) {
		this.sgCompanyInfo = sgCompanyInfo;
		this.sendName = sendName;
		this.sendPaperQuestion = sendPaperQuestion;
		this.sendTrainee = sendTrainee;
		this.sendStartTime = sendStartTime;
		this.sendEndTime = sendEndTime;
		this.sendStatus = sendStatus;
		this.sendType = sendType;
		this.sgReceiveInfos = sgReceiveInfos;
	}

	// Property accessors

	public Long getSendId() {
		return this.sendId;
	}

	public void setSendId(Long sendId) {
		this.sendId = sendId;
	}

	public SgCompanyInfo getSgCompanyInfo() {
		return this.sgCompanyInfo;
	}

	public void setSgCompanyInfo(SgCompanyInfo sgCompanyInfo) {
		this.sgCompanyInfo = sgCompanyInfo;
	}

	public String getSendName() {
		return this.sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public Long getSendPaperQuestion() {
		return this.sendPaperQuestion;
	}

	public void setSendPaperQuestion(Long sendPaperQuestion) {
		this.sendPaperQuestion = sendPaperQuestion;
	}

	public Long getSendTrainee() {
		return this.sendTrainee;
	}

	public void setSendTrainee(Long sendTrainee) {
		this.sendTrainee = sendTrainee;
	}

	public Date getSendStartTime() {
		return this.sendStartTime;
	}

	public void setSendStartTime(Date sendStartTime) {
		this.sendStartTime = sendStartTime;
	}

	public Date getSendEndTime() {
		return this.sendEndTime;
	}

	public void setSendEndTime(Date sendEndTime) {
		this.sendEndTime = sendEndTime;
	}

	public Integer getSendStatus() {
		return this.sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Integer getSendType() {
		return this.sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Set getSgReceiveInfos() {
		return this.sgReceiveInfos;
	}

	public void setSgReceiveInfos(Set sgReceiveInfos) {
		this.sgReceiveInfos = sgReceiveInfos;
	}

}