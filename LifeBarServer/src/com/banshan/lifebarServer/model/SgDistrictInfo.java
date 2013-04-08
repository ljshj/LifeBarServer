package com.banshan.lifebarServer.model;

/**
 * SgDistrictInfo entity. @author MyEclipse Persistence Tools
 */

public class SgDistrictInfo implements java.io.Serializable {

	// Fields

	private Long districtId;
	private SgCompanyInfo sgCompanyInfo;
	private String districtName;
	private String districtRemark;

	// Constructors

	/** default constructor */
	public SgDistrictInfo() {
	}

	/** minimal constructor */
	public SgDistrictInfo(String districtName) {
		this.districtName = districtName;
	}

	/** full constructor */
	public SgDistrictInfo(SgCompanyInfo sgCompanyInfo, String districtName,
			String districtRemark) {
		this.sgCompanyInfo = sgCompanyInfo;
		this.districtName = districtName;
		this.districtRemark = districtRemark;
	}

	// Property accessors

	public Long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public SgCompanyInfo getSgCompanyInfo() {
		return this.sgCompanyInfo;
	}

	public void setSgCompanyInfo(SgCompanyInfo sgCompanyInfo) {
		this.sgCompanyInfo = sgCompanyInfo;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictRemark() {
		return this.districtRemark;
	}

	public void setDistrictRemark(String districtRemark) {
		this.districtRemark = districtRemark;
	}

}