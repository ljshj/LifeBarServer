package com.banshan.lifebarServer.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3527561661397035091L;
	@JSON(serialize=false) 
	public Log getLog(){
		return LogFactory.getLog(this.getClass());
	}
	@JSON(serialize=false) 
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	} 
	@JSON(serialize=false) 
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	} 
	@JSON(serialize=false) 
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	public void outJsonString(String str){
		getLog().info(str);
		getResponse().setContentType("text/javascript;charset=utf-8");
		outString(str);
	}
	@SuppressWarnings("unchecked")
	public void clearSession(){
		for(Enumeration items=getSession().getAttributeNames();items.hasMoreElements();){
			String item=(String)items.nextElement();
			getSession().removeAttribute(item);
		}
	}
	public void outJson(Object obj){
		getLog().info(JSONObject.fromObject(obj).toString());
		outJsonString(JSONObject.fromObject(obj).toString());
	}
	public void outJsonArray(Object array){
		getLog().info(JSONArray.fromObject(array).toString());
		outString(JSONArray.fromObject(array).toString());
	}
	public void outString(String str){
		try {
			PrintWriter out=getResponse().getWriter();
			getLog().info(str);
			out.write(str);
			//清空缓存
			out.flush();
			// 关闭流
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
