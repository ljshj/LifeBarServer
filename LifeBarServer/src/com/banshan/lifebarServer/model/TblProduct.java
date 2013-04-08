package com.banshan.lifebarServer.model;

import java.sql.Timestamp;

/**
 * TblProduct entity. @author MyEclipse Persistence Tools
 */

public class TblProduct implements java.io.Serializable
{

	// Fields

	private Long productId;
	private String name;
	private Short status;
	private Integer type;
	private String detail;
	private Integer priority;
	private Integer orgid;
	private Timestamp effdate;
	private Timestamp expdate;
	private Double price;
	private Integer amount;

	// Constructors

	/** default constructor */
	public TblProduct()
	{
	}

	/** minimal constructor */
	public TblProduct(String name, Short status, Integer type,
			Integer priority, Integer orgid, Double price, Integer amount)
	{
		this.name = name;
		this.status = status;
		this.type = type;
		this.priority = priority;
		this.orgid = orgid;
		this.price = price;
		this.amount = amount;
	}

	/** full constructor */
	public TblProduct(String name, Short status, Integer type, String detail,
			Integer priority, Integer orgid, Timestamp effdate,
			Timestamp expdate, Double price, Integer amount)
	{
		this.name = name;
		this.status = status;
		this.type = type;
		this.detail = detail;
		this.priority = priority;
		this.orgid = orgid;
		this.effdate = effdate;
		this.expdate = expdate;
		this.price = price;
		this.amount = amount;
	}

	// Property accessors

	public Long getProductId()
	{
		return this.productId;
	}

	public void setProductId(Long productId)
	{
		this.productId = productId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Short getStatus()
	{
		return this.status;
	}

	public void setStatus(Short status)
	{
		this.status = status;
	}

	public Integer getType()
	{
		return this.type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public String getDetail()
	{
		return this.detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public Integer getPriority()
	{
		return this.priority;
	}

	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}

	public Integer getOrgid()
	{
		return this.orgid;
	}

	public void setOrgid(Integer orgid)
	{
		this.orgid = orgid;
	}

	public Timestamp getEffdate()
	{
		return this.effdate;
	}

	public void setEffdate(Timestamp effdate)
	{
		this.effdate = effdate;
	}

	public Timestamp getExpdate()
	{
		return this.expdate;
	}

	public void setExpdate(Timestamp expdate)
	{
		this.expdate = expdate;
	}

	public Double getPrice()
	{
		return this.price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Integer getAmount()
	{
		return this.amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

}