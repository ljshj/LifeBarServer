package com.banshan.lifebarServer.model;

import java.util.Date;

/**
 * SgReceiveInfo entity. @author MyEclipse Persistence Tools
 */

public class SgReceiveInfo implements java.io.Serializable {

	// Fields

	private Long receiveId;
	private SgSendInfo sgSendInfo;
	private Long sendContentId;
	private String sendContent;
	private String receiveContent;
	private Date sendTime;
	private Date receiveTime;
	private Boolean sendSuccess;
	private Integer sendTimes;

	// Constructors

	/** default constructor */
	public SgReceiveInfo() {
	}

	/** minimal constructor */
	public SgReceiveInfo(Long sendContentId, String sendContent,
			Date sendTime, Boolean sendSuccess, Integer sendTimes) {
		this.sendContentId = sendContentId;
		this.sendContent = sendContent;
		this.sendTime = sendTime;
		this.sendSuccess = sendSuccess;
		this.sendTimes = sendTimes;
	}

	/** full constructor */
	public SgReceiveInfo(SgSendInfo sgSendInfo, Long sendContentId,
			String sendContent, String receiveContent, Date sendTime,
			Date receiveTime, Boolean sendSuccess, Integer sendTimes) {
		this.sgSendInfo = sgSendInfo;
		this.sendContentId = sendContentId;
		this.sendContent = sendContent;
		this.receiveContent = receiveContent;
		this.sendTime = sendTime;
		this.receiveTime = receiveTime;
		this.sendSuccess = sendSuccess;
		this.sendTimes = sendTimes;
	}

	// Property accessors

	public Long getReceiveId() {
		return this.receiveId;
	}

	public void setReceiveId(Long receiveId) {
		this.receiveId = receiveId;
	}

	public SgSendInfo getSgSendInfo() {
		return this.sgSendInfo;
	}

	public void setSgSendInfo(SgSendInfo sgSendInfo) {
		this.sgSendInfo = sgSendInfo;
	}

	public Long getSendContentId() {
		return this.sendContentId;
	}

	public void setSendContentId(Long sendContentId) {
		this.sendContentId = sendContentId;
	}

	public String getSendContent() {
		return this.sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public String getReceiveContent() {
		return this.receiveContent;
	}

	public void setReceiveContent(String receiveContent) {
		this.receiveContent = receiveContent;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Boolean getSendSuccess() {
		return this.sendSuccess;
	}

	public void setSendSuccess(Boolean sendSuccess) {
		this.sendSuccess = sendSuccess;
	}

	public Integer getSendTimes() {
		return this.sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

}