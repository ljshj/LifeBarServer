package com.banshan.lifebarServer.model;

/**
 * TblProductType entity. @author MyEclipse Persistence Tools
 */

public class TblProductType implements java.io.Serializable
{

	// Fields

	private Integer typeId;
	private String name;
	private Integer parent;
	private Integer orgId;

	// Constructors

	/** default constructor */
	public TblProductType()
	{
	}

	/** full constructor */
	public TblProductType(String name, Integer parent, Integer orgId)
	{
		this.name = name;
		this.parent = parent;
		this.orgId = orgId;
	}

	// Property accessors

	public Integer getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(Integer typeId)
	{
		this.typeId = typeId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getParent()
	{
		return this.parent;
	}

	public void setParent(Integer parent)
	{
		this.parent = parent;
	}

	public Integer getOrgId()
	{
		return this.orgId;
	}

	public void setOrgId(Integer orgId)
	{
		this.orgId = orgId;
	}

}