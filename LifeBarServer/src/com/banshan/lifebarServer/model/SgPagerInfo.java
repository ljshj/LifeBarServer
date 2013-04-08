package com.banshan.lifebarServer.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SgPagerInfo entity. @author MyEclipse Persistence Tools
 */

public class SgPagerInfo implements java.io.Serializable {

	// Fields

	private Long Id;
	private String text;
	private Long parentId;
	private Boolean leaf;
	private String linkUrl;
	private String iconCls;
	private Integer pagerStatus;
	private String pagerRemark;
	private Set sgUserPowers = new HashSet(0);

	// Constructors

	/** default constructor */
	public SgPagerInfo() {
	}

	/** minimal constructor */
	public SgPagerInfo(String pagerName, Long pagerParent, Boolean pagerIsLeaf,
			String pagerUrlLink, String pagerIconCls, Integer pagerStatus,
			String pagerRemark) {
		this.text = pagerName;
		this.parentId = pagerParent;
		this.leaf = pagerIsLeaf;
		this.linkUrl = pagerUrlLink;
		this.iconCls = pagerIconCls;
		this.pagerStatus = pagerStatus;
		this.pagerRemark = pagerRemark;
	}

	/** full constructor */
	public SgPagerInfo(String pagerName, Long pagerParent, Boolean pagerIsLeaf,
			String pagerUrlLink, String pagerIconCls, Integer pagerStatus,
			String pagerRemark, Set sgUserPowers) {
		this.text = pagerName;
		this.parentId = pagerParent;
		this.leaf = pagerIsLeaf;
		this.linkUrl = pagerUrlLink;
		this.iconCls = pagerIconCls;
		this.pagerStatus = pagerStatus;
		this.pagerRemark = pagerRemark;
		this.sgUserPowers = sgUserPowers;
	}

	// Property accessors

	public Integer getPagerStatus() {
		return this.pagerStatus;
	}

	public void setPagerStatus(Integer pagerStatus) {
		this.pagerStatus = pagerStatus;
	}

	public String getPagerRemark() {
		return this.pagerRemark;
	}

	public void setPagerRemark(String pagerRemark) {
		this.pagerRemark = pagerRemark;
	}

	public Set getSgUserPowers() {
		return this.sgUserPowers;
	}

	public void setSgUserPowers(Set sgUserPowers) {
		this.sgUserPowers = sgUserPowers;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

}