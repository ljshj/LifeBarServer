package com.banshan.lifebarServer.model;

/**
 * SgPortInfo entity. @author MyEclipse Persistence Tools
 */

public class SgPortInfo implements java.io.Serializable {

	// Fields

	private Long portId;
	private SgCompanyInfo sgCompanyInfo;
	private String portNumber;
	private Integer portType;
	private String portRemark;

	// Constructors

	/** default constructor */
	public SgPortInfo() {
	}

	/** minimal constructor */
	public SgPortInfo(String portNumber, Integer portType) {
		this.portNumber = portNumber;
		this.portType = portType;
	}

	/** full constructor */
	public SgPortInfo(SgCompanyInfo sgCompanyInfo, String portNumber,
			Integer portType, String portRemark) {
		this.sgCompanyInfo = sgCompanyInfo;
		this.portNumber = portNumber;
		this.portType = portType;
		this.portRemark = portRemark;
	}

	// Property accessors

	public Long getPortId() {
		return this.portId;
	}

	public void setPortId(Long portId) {
		this.portId = portId;
	}

	public SgCompanyInfo getSgCompanyInfo() {
		return this.sgCompanyInfo;
	}

	public void setSgCompanyInfo(SgCompanyInfo sgCompanyInfo) {
		this.sgCompanyInfo = sgCompanyInfo;
	}

	public String getPortNumber() {
		return this.portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public Integer getPortType() {
		return this.portType;
	}

	public void setPortType(Integer portType) {
		this.portType = portType;
	}

	public String getPortRemark() {
		return this.portRemark;
	}

	public void setPortRemark(String portRemark) {
		this.portRemark = portRemark;
	}

}