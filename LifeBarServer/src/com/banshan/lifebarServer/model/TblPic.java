package com.banshan.lifebarServer.model;

/**
 * TblPic entity. @author MyEclipse Persistence Tools
 */

public class TblPic implements java.io.Serializable
{

	// Fields

	private Long id;
	private Long refId;
	private Short refType;
	private Short type;
	private String link;

	// Constructors

	/** default constructor */
	public TblPic()
	{
	}

	/** full constructor */
	public TblPic(Long refId, Short refType, Short type, String link)
	{
		this.refId = refId;
		this.refType = refType;
		this.type = type;
		this.link = link;
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

	public Long getRefId()
	{
		return this.refId;
	}

	public void setRefId(Long refId)
	{
		this.refId = refId;
	}

	public Short getRefType()
	{
		return this.refType;
	}

	public void setRefType(Short refType)
	{
		this.refType = refType;
	}

	public Short getType()
	{
		return this.type;
	}

	public void setType(Short type)
	{
		this.type = type;
	}

	public String getLink()
	{
		return this.link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

}