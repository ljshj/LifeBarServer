package com.banshan.lifebarServer.model;

/**
 * TblTypeOfProduct entity. @author MyEclipse Persistence Tools
 */

public class TblTypeOfProduct implements java.io.Serializable
{

	// Fields

	private Long id;
	private Long productId;
	private Integer typeId;

	// Constructors

	/** default constructor */
	public TblTypeOfProduct()
	{
	}

	/** full constructor */
	public TblTypeOfProduct(Long productId, Integer typeId)
	{
		this.productId = productId;
		this.typeId = typeId;
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

	public Long getProductId()
	{
		return this.productId;
	}

	public void setProductId(Long productId)
	{
		this.productId = productId;
	}

	public Integer getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(Integer typeId)
	{
		this.typeId = typeId;
	}

}