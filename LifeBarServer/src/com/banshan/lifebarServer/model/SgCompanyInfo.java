package com.banshan.lifebarServer.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SgCompanyInfo entity. @author MyEclipse Persistence Tools
 */

public class SgCompanyInfo implements java.io.Serializable {

	// Fields

	private Long companyId;
	private String companyName;
	private String companyEnglishName;
	private String companyShortName;
	private String companyPhone;
	private String companyAddress;
	private String companyEmail;
	private String companyIntro;
	private String companyWebsite;
	private String companyTrain;
	private Set sgSendInfos = new HashSet(0);
	private Set sgDistrictInfos = new HashSet(0);
	private Set sgCategoryInfos = new HashSet(0);
	private Set sgPortInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgCompanyInfo() {
	}

	/** minimal constructor */
	public SgCompanyInfo(String companyName, String companyShortName,
			String companyPhone, String companyAddress, String companyEmail,
			String companyIntro, String companyTrain) {
		this.companyName = companyName;
		this.companyShortName = companyShortName;
		this.companyPhone = companyPhone;
		this.companyAddress = companyAddress;
		this.companyEmail = companyEmail;
		this.companyIntro = companyIntro;
		this.companyTrain = companyTrain;
	}

	/** full constructor */
	public SgCompanyInfo(String companyName, String companyEnglishName,
			String companyShortName, String companyPhone,
			String companyAddress, String companyEmail, String companyIntro,
			String companyWebsite, String companyTrain, Set sgSendInfos,
			Set sgDistrictInfos, Set sgCategoryInfos, Set sgPortInfos) {
		this.companyName = companyName;
		this.companyEnglishName = companyEnglishName;
		this.companyShortName = companyShortName;
		this.companyPhone = companyPhone;
		this.companyAddress = companyAddress;
		this.companyEmail = companyEmail;
		this.companyIntro = companyIntro;
		this.companyWebsite = companyWebsite;
		this.companyTrain = companyTrain;
		this.sgSendInfos = sgSendInfos;
		this.sgDistrictInfos = sgDistrictInfos;
		this.sgCategoryInfos = sgCategoryInfos;
		this.sgPortInfos = sgPortInfos;
	}

	// Property accessors

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEnglishName() {
		return this.companyEnglishName;
	}

	public void setCompanyEnglishName(String companyEnglishName) {
		this.companyEnglishName = companyEnglishName;
	}

	public String getCompanyShortName() {
		return this.companyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public String getCompanyPhone() {
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyEmail() {
		return this.companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyIntro() {
		return this.companyIntro;
	}

	public void setCompanyIntro(String companyIntro) {
		this.companyIntro = companyIntro;
	}

	public String getCompanyWebsite() {
		return this.companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyTrain() {
		return this.companyTrain;
	}

	public void setCompanyTrain(String companyTrain) {
		this.companyTrain = companyTrain;
	}

	public Set getSgSendInfos() {
		return this.sgSendInfos;
	}

	public void setSgSendInfos(Set sgSendInfos) {
		this.sgSendInfos = sgSendInfos;
	}

	public Set getSgDistrictInfos() {
		return this.sgDistrictInfos;
	}

	public void setSgDistrictInfos(Set sgDistrictInfos) {
		this.sgDistrictInfos = sgDistrictInfos;
	}

	public Set getSgCategoryInfos() {
		return this.sgCategoryInfos;
	}

	public void setSgCategoryInfos(Set sgCategoryInfos) {
		this.sgCategoryInfos = sgCategoryInfos;
	}

	public Set getSgPortInfos() {
		return this.sgPortInfos;
	}

	public void setSgPortInfos(Set sgPortInfos) {
		this.sgPortInfos = sgPortInfos;
	}

}