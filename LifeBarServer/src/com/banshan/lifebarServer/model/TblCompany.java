package com.banshan.lifebarServer.model;

import java.sql.Timestamp;

/**
 * TblCompany entity. @author MyEclipse Persistence Tools
 */

public class TblCompany implements java.io.Serializable
{

	// Fields

	private Integer companyId;
	private String account;
	private String cname;
	private String cpwd;
	private String cface;
	private Timestamp joindate;
	private Timestamp lastlogin;
	private String cclass;
	private String cgroup;
	private Integer cgroupid;
	private Short cstatus;
	private Long credit;
	private String email;
	private String detail;
	private Short type;
	private Integer parent;
	private String phone;
	private String mobile;
	private String website;
	private String state;
	private String city;
	private String street;
	private String zip;
	private Double latitude;
	private Double longitude;

	// Constructors

	/** default constructor */
	public TblCompany()
	{
	}

	/** minimal constructor */
	public TblCompany(String account, String cname, String cpwd,
			Timestamp joindate, Integer cgroupid, Short cstatus, Long credit,
			String email, Short type, Integer parent)
	{
		this.account = account;
		this.cname = cname;
		this.cpwd = cpwd;
		this.joindate = joindate;
		this.cgroupid = cgroupid;
		this.cstatus = cstatus;
		this.credit = credit;
		this.email = email;
		this.type = type;
		this.parent = parent;
	}

	/** full constructor */
	public TblCompany(String account, String cname, String cpwd, String cface,
			Timestamp joindate, Timestamp lastlogin, String cclass,
			String cgroup, Integer cgroupid, Short cstatus, Long credit,
			String email, String detail, Short type, Integer parent,
			String phone, String mobile, String website, String state,
			String city, String street, String zip, Double latitude,
			Double longitude)
	{
		this.account = account;
		this.cname = cname;
		this.cpwd = cpwd;
		this.cface = cface;
		this.joindate = joindate;
		this.lastlogin = lastlogin;
		this.cclass = cclass;
		this.cgroup = cgroup;
		this.cgroupid = cgroupid;
		this.cstatus = cstatus;
		this.credit = credit;
		this.email = email;
		this.detail = detail;
		this.type = type;
		this.parent = parent;
		this.phone = phone;
		this.mobile = mobile;
		this.website = website;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// Property accessors

	public Integer getCompanyId()
	{
		return this.companyId;
	}

	public void setCompanyId(Integer companyId)
	{
		this.companyId = companyId;
	}

	public String getAccount()
	{
		return this.account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getCname()
	{
		return this.cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public String getCpwd()
	{
		return this.cpwd;
	}

	public void setCpwd(String cpwd)
	{
		this.cpwd = cpwd;
	}

	public String getCface()
	{
		return this.cface;
	}

	public void setCface(String cface)
	{
		this.cface = cface;
	}

	public Timestamp getJoindate()
	{
		return this.joindate;
	}

	public void setJoindate(Timestamp joindate)
	{
		this.joindate = joindate;
	}

	public Timestamp getLastlogin()
	{
		return this.lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin)
	{
		this.lastlogin = lastlogin;
	}

	public String getCclass()
	{
		return this.cclass;
	}

	public void setCclass(String cclass)
	{
		this.cclass = cclass;
	}

	public String getCgroup()
	{
		return this.cgroup;
	}

	public void setCgroup(String cgroup)
	{
		this.cgroup = cgroup;
	}

	public Integer getCgroupid()
	{
		return this.cgroupid;
	}

	public void setCgroupid(Integer cgroupid)
	{
		this.cgroupid = cgroupid;
	}

	public Short getCstatus()
	{
		return this.cstatus;
	}

	public void setCstatus(Short cstatus)
	{
		this.cstatus = cstatus;
	}

	public Long getCredit()
	{
		return this.credit;
	}

	public void setCredit(Long credit)
	{
		this.credit = credit;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDetail()
	{
		return this.detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public Short getType()
	{
		return this.type;
	}

	public void setType(Short type)
	{
		this.type = type;
	}

	public Integer getParent()
	{
		return this.parent;
	}

	public void setParent(Integer parent)
	{
		this.parent = parent;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getMobile()
	{
		return this.mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getWebsite()
	{
		return this.website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getStreet()
	{
		return this.street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getZip()
	{
		return this.zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public Double getLatitude()
	{
		return this.latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	public Double getLongitude()
	{
		return this.longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

}