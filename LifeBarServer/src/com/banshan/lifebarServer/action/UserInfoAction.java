package com.banshan.lifebarServer.action;

import javax.annotation.Resource;

import com.banshan.lifebarServer.common.SystemStatic;
import com.banshan.lifebarServer.model.TblUser;
import com.banshan.lifebarServer.service.UserInfoService;

public class UserInfoAction extends BaseJsonAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8674590199835870752L;
	
	@Resource UserInfoService userInfoService;
	private String account;
	private String password;
	private TblUser user;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TblUser getUser() {
		return user;
	}

	public void setUser(TblUser user) {
		this.user = user;
	}

	public String login()
	{
		user = userInfoService.findUserByAccount(account);
		if(user == null || !user.getUserpwd().equals(password))
		{
			return setFailCode(SystemStatic.FAIL_CODE_USER_LOGINFAIL);
		}
		setSuccessMessage("");
		return SUCCESS;
	}

}
