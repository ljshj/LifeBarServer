package com.banshan.lifebarServer.model;

/**
 * TblDiscountcard entity. @author MyEclipse Persistence Tools
 */

public class TblDiscountcard implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer orgId;
	private String name;
	private String detail;
	private Short overlay;
	private Short type;
	private String value;

	// Constructors

	/** default constructor */
	public TblDiscountcard()
	{
	}

	/** minimal constructor */
	public TblDiscountcard(Integer orgId, String name, String detail,
			Short overlay, Short type)
	{
		this.orgId = orgId;
		this.name = name;
		this.detail = detail;
		this.overlay = overlay;
		this.type = type;
	}

	/** full constructor */
	public TblDiscountcard(Integer orgId, String name, String detail,
			Short overlay, Short type, String value)
	{
		this.orgId = orgId;
		this.name = name;
		this.detail = detail;
		this.overlay = overlay;
		this.type = type;
		this.value = value;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getOrgId()
	{
		return this.orgId;
	}

	public void setOrgId(Integer orgId)
	{
		this.orgId = orgId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDetail()
	{
		return this.detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public Short getOverlay()
	{
		return this.overlay;
	}

	public void setOverlay(Short overlay)
	{
		this.overlay = overlay;
	}

	public Short getType()
	{
		return this.type;
	}

	public void setType(Short type)
	{
		this.type = type;
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