package com.banshan.lifebarServer.model;

import java.sql.Timestamp;

/**
 * TblUser entity. @author MyEclipse Persistence Tools
 */

public class TblUser implements java.io.Serializable
{

	// Fields

	private Long userid;
	private String account;
	private String username;
	private String userpwd;
	private String usermail;
	private Short usersex;
	private String userface;
	private String userphone;
	private Timestamp joindate;
	private Timestamp lastlogin;
	private Short userstatus;
	private String userclass;
	private String usergroup;
	private Integer usergroupid;
	private Long credit;
	private String detail;

	// Constructors

	/** default constructor */
	public TblUser()
	{
	}

	/** minimal constructor */
	public TblUser(String account, String username, String userpwd,
			String usermail, Short usersex, Timestamp joindate,
			Short userstatus, String userclass, Integer usergroupid)
	{
		this.account = account;
		this.username = username;
		this.userpwd = userpwd;
		this.usermail = usermail;
		this.usersex = usersex;
		this.joindate = joindate;
		this.userstatus = userstatus;
		this.userclass = userclass;
		this.usergroupid = usergroupid;
	}

	/** full constructor */
	public TblUser(String account, String username, String userpwd,
			String usermail, Short usersex, String userface, String userphone,
			Timestamp joindate, Timestamp lastlogin, Short userstatus,
			String userclass, String usergroup, Integer usergroupid,
			Long credit, String detail)
	{
		this.account = account;
		this.username = username;
		this.userpwd = userpwd;
		this.usermail = usermail;
		this.usersex = usersex;
		this.userface = userface;
		this.userphone = userphone;
		this.joindate = joindate;
		this.lastlogin = lastlogin;
		this.userstatus = userstatus;
		this.userclass = userclass;
		this.usergroup = usergroup;
		this.usergroupid = usergroupid;
		this.credit = credit;
		this.detail = detail;
	}

	// Property accessors

	public Long getUserid()
	{
		return this.userid;
	}

	public void setUserid(Long userid)
	{
		this.userid = userid;
	}

	public String getAccount()
	{
		return this.account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUserpwd()
	{
		return this.userpwd;
	}

	public void setUserpwd(String userpwd)
	{
		this.userpwd = userpwd;
	}

	public String getUsermail()
	{
		return this.usermail;
	}

	public void setUsermail(String usermail)
	{
		this.usermail = usermail;
	}

	public Short getUsersex()
	{
		return this.usersex;
	}

	public void setUsersex(Short usersex)
	{
		this.usersex = usersex;
	}

	public String getUserface()
	{
		return this.userface;
	}

	public void setUserface(String userface)
	{
		this.userface = userface;
	}

	public String getUserphone()
	{
		return this.userphone;
	}

	public void setUserphone(String userphone)
	{
		this.userphone = userphone;
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

	public Short getUserstatus()
	{
		return this.userstatus;
	}

	public void setUserstatus(Short userstatus)
	{
		this.userstatus = userstatus;
	}

	public String getUserclass()
	{
		return this.userclass;
	}

	public void setUserclass(String userclass)
	{
		this.userclass = userclass;
	}

	public String getUsergroup()
	{
		return this.usergroup;
	}

	public void setUsergroup(String usergroup)
	{
		this.usergroup = usergroup;
	}

	public Integer getUsergroupid()
	{
		return this.usergroupid;
	}

	public void setUsergroupid(Integer usergroupid)
	{
		this.usergroupid = usergroupid;
	}

	public Long getCredit()
	{
		return this.credit;
	}

	public void setCredit(Long credit)
	{
		this.credit = credit;
	}

	public String getDetail()
	{
		return this.detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

}