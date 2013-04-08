package com.banshan.lifebarServer.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * SgMo entity. @author MyEclipse Persistence Tools
 */

public class SgMo implements java.io.Serializable {

	// Fields

	private Long id;
	private String operation;
	private String netOperator;
	private String serviceId;
	private Date dateTime;
	private String terminalNumber;
	private String srcNumber;
	private String messageContent;
	private String linkId;

	// Constructors

	/** default constructor */
	public SgMo() {
	}

	/** full constructor */
	public SgMo(String operation, String netOperator, String serviceId,
			Date dateTime, String terminalNumber, String srcNumber,
			String messageContent, String linkId) {
		this.operation = operation;
		this.netOperator = netOperator;
		this.serviceId = serviceId;
		this.dateTime = dateTime;
		this.terminalNumber = terminalNumber;
		this.srcNumber = srcNumber;
		this.messageContent = messageContent;
		this.linkId = linkId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getNetOperator() {
		return this.netOperator;
	}

	public void setNetOperator(String netOperator) {
		this.netOperator = netOperator;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getTerminalNumber() {
		return this.terminalNumber;
	}

	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public String getSrcNumber() {
		return this.srcNumber;
	}

	public void setSrcNumber(String srcNumber) {
		this.srcNumber = srcNumber;
	}

	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getLinkId() {
		return this.linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

}