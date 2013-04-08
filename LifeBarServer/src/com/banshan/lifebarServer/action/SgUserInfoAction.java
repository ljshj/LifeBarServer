package com.banshan.lifebarServer.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import com.banshan.lifebarServer.model.SgUserInfo;
import com.banshan.lifebarServer.model.SgUserPower;
import com.banshan.lifebarServer.service.BaseService;
import com.banshan.lifebarServer.service.SgUserInfoService;
import com.banshan.lifebarServer.util.ListRange;
import com.banshan.lifebarServer.util.SendMail;

/**
 * @author WSQ
 * @date 2010年5月5日
 * @class SgUserInfoAction
 * @description 人员操作类，包括用户登录，增删查改等
 */
public class SgUserInfoAction extends BaseAction {

	/**
	 * 用户管理类
	 */
	private static final long serialVersionUID = 1L;
	@Resource SgUserInfoService sgUserInfoService;
	@Resource BaseService<SgUserInfo> sgUserInfoBaseService;
	
	private String message;
	private List<SgUserInfo> users;
	private SgUserInfo user;
	private String randCode;
	
	/**
	 * 用户登录
	 */
	@SuppressWarnings("unchecked")
	public void login(){
		ListRange userRange=new ListRange();
		getResponse().setCharacterEncoding("UTF-8");
		Pattern pattern = Pattern.compile("^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\\d{8}$",Pattern.CASE_INSENSITIVE);
		try {
			String rand=this.getSession().getAttribute("rand").toString();
			if(rand.equals(randCode)){
				Matcher matcher = pattern.matcher(this.user.getUserPhone());
				if(!matcher.matches()){
					userRange.setSuccess(false);
					userRange.setMessage("输入帐号不存在，请重新登陆！");
				}
				else{
					this.users=sgUserInfoService.findByUserPhone(user.getUserPhone());
					if(this.users.size()>0){
						SgUserPower sp=new SgUserPower();
						SgUserInfo ui=this.users.get(0);
						if(ui.getUserPassword().equals(this.user.getUserPassword())){
							Set<SgUserPower> set=ui.getSgUserGroup().getSgUserPowers();
							getLog().info(set.size());
							Iterator<SgUserPower> iterator=set.iterator();
							while(iterator.hasNext()){
								sp=iterator.next();
								getLog().info(sp.getSgPagerInfo().getText());
							}
							getLog().info("UserGroup="+ui.getSgUserGroup().getGroupName());
							getSession().setAttribute("user", this.users.get(0));
							userRange.setSuccess(true);
							userRange.setMessage("登陆成功");
						}
						else{
							userRange.setSuccess(false);
							userRange.setMessage("密码错误，请重新登陆！");
						}
					}
					else{
						userRange.setSuccess(false);
						userRange.setMessage("输入帐号不存在，请重新登陆！");
					}
				}
			}
			else{
				userRange.setSuccess(false);
				userRange.setMessage("登陆失败,验证码错误");
			}
			outJson(userRange);
		} catch (Exception e) {
			userRange.setSuccess(false);
			userRange.setMessage(e.getMessage()+"<br/>"+e.getLocalizedMessage());
			outJson(userRange);
		}
	}
	
	/**
	 * 修改密码
	 */
	@SuppressWarnings("unchecked")
	public void modifypwd(){
		ListRange userRange=new ListRange();
		try {
			getResponse().setCharacterEncoding("UTF-8");
			String oldpassword=getRequest().getParameter("oldpassword");
			String newpassword=getRequest().getParameter("newpassword");
			String checkpassword=getRequest().getParameter("checkpassword");
			getLog().info(oldpassword+":"+newpassword+":"+checkpassword);
			Pattern pattern = Pattern.compile("^([A-Z]|[a-z]|[\\d])*$",Pattern.CASE_INSENSITIVE);
			if(pattern.matcher(oldpassword).matches()&&pattern.matcher(newpassword).matches()&&pattern.matcher(checkpassword).matches())
			{
				this.user=(SgUserInfo) getSession().getAttribute("user");
				if(oldpassword.equals(this.user.getUserPassword())){
					if(newpassword.equals(checkpassword)){
						this.user.setUserPassword(newpassword);
						sgUserInfoBaseService.update(this.user);
						getSession().setAttribute("user", this.user);
						userRange.setMessage("修改密码成功");
						userRange.setSuccess(true);
					}
					else{
						userRange.setMessage("两次输入密码不一致");
						userRange.setSuccess(false);
					}
				}
				else{
					userRange.setMessage("原始密码错误");
					userRange.setSuccess(false);
				}
			}
			else{
				userRange.setMessage("密码格式错误");
				userRange.setSuccess(false);
			}
			outJson(userRange);
		} catch (Exception e) {
			userRange.setSuccess(false);
			userRange.setMessage(e.getLocalizedMessage());
			outJson(userRange);
		}
	}
	
	/**
	 * 用户注销、退出
	 */
	@SuppressWarnings("unchecked")
	public void logout(){
		ListRange userRange=new ListRange();
		try {
			int op=Integer.parseInt(getRequest().getParameter("op"));
			clearSession();
			SgUserInfo sgUserInfo=(SgUserInfo) getSession().getAttribute("user");
			if(sgUserInfo!=null){
				getLog().info(sgUserInfo.getUserName());
			}
			if(op==0){
				userRange.setMessage("注销成功");
			}
			else{
				userRange.setMessage("退出成功");
			}
			userRange.setSuccess(true);
			outJson(userRange);
		} catch (Exception e) {
			userRange.setSuccess(false);
			userRange.setMessage(e.getLocalizedMessage());
			outJson(userRange);
		}
	}
	
	/**
	 * 取回密码
	 */
	@SuppressWarnings("unchecked")
	public void recover(){
		ListRange userRange=new ListRange();
		String phone=getRequest().getParameter("phone");
		getLog().info(phone);
		getResponse().setCharacterEncoding("UTF-8");
		Pattern pattern = Pattern.compile("^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\\d{8}$",Pattern.CASE_INSENSITIVE);
		try {
			String rand=this.getSession().getAttribute("rand").toString();
			getLog().info(randCode);
			if(rand.equals(randCode)){
				Matcher matcher = pattern.matcher(phone);
				if(!matcher.matches()){
					userRange.setSuccess(false);
					userRange.setMessage("输入帐号不存在，请重新输入！");
				}
				else{
					this.users=sgUserInfoService.findByUserPhone(phone);
					if(this.users.size()>0){
						SgUserInfo ui=this.users.get(0);
						SendMail sendMail=new SendMail();
						sendMail.setHost("smtp.163.com");
						sendMail.setMailfrom("wsh20055523@163.com");
						sendMail.setAccount("wsh20055523");
						sendMail.setPassword("XXXXXX");
						sendMail.setContent("帐号："+ui.getUserPhone()+";密码："+ui.getUserPassword());
						sendMail.setMailto(ui.getUserEmail());
						if(sendMail.sendEmail()){
							userRange.setSuccess(true);
							userRange.setMessage("密码已经发送到您的邮箱，<br/>请注意查收！");
						}
						else{
							userRange.setSuccess(false);
							userRange.setMessage("寻回密码失败！");
						}
					}
					else{
						userRange.setSuccess(false);
						userRange.setMessage("输入帐号不存在，请重新输入！");
					}
				}
			}
			else{
				userRange.setSuccess(false);
				userRange.setMessage("寻回密码失败,验证码错误");
			}
			outJson(userRange);
		} catch (Exception e) {
			userRange.setSuccess(false);
			userRange.setMessage(e.getMessage()+"<br/>"+e.getLocalizedMessage());
			outJson(userRange);
		}
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<SgUserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<SgUserInfo> users) {
		this.users = users;
	}

	public SgUserInfo getUser() {
		return user;
	}

	public void setUser(SgUserInfo user) {
		this.user = user;
	}

	public String getRandCode() {
		return randCode;
	}

	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}
	
}
