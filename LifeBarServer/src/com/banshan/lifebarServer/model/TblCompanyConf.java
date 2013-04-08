package com.banshan.lifebarServer.model;

/**
 * TblCompanyConf entity. @author MyEclipse Persistence Tools
 */

public class TblCompanyConf implements java.io.Serializable
{

	// Fields

	private Long id;
	private Integer companyId;
	private String name;
	private String value;

	// Constructors

	/** default constructor */
	public TblCompanyConf()
	{
	}

	/** minimal constructor */
	public TblCompanyConf(Integer companyId, String name)
	{
		this.companyId = companyId;
		this.name = name;
	}

	/** full constructor */
	public TblCompanyConf(Integer companyId, String name, String value)
	{
		this.companyId = companyId;
		this.name = name;
		this.value = value;
	}

	// Property accessors

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getCompanyId()
	{
		return this.companyId;
	}

	public void setCompanyId(Integer companyId)
	{
		this.companyId = companyId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return this.value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}