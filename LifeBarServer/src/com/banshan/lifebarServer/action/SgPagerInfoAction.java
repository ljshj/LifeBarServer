package com.banshan.lifebarServer.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import com.banshan.lifebarServer.model.SgPagerInfo;
import com.banshan.lifebarServer.model.SgUserInfo;
import com.banshan.lifebarServer.service.BaseService;
import com.banshan.lifebarServer.service.SgPagerInfoService;

/**
 * @author WSQ
 * @date 2010年5月5日
 * @class SgPagerInfoAction
 * @description 菜单操作类，包括查找菜单等
 */
public class SgPagerInfoAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5932930439263848313L;
	/**
	 * 页面管理
	 */
	@Resource BaseService<SgPagerInfo> sgPageInfoBaseService;
	@Resource SgPagerInfoService sgPagerInfoService;
	
	private String message;
	private List<SgPagerInfo> sgPagerInfos;
	private SgPagerInfo sgPagerInfo;
	private String node;
	
	/**
	 * 读取菜单信息
	 * @return "loadTree"
	 */
	public void loadTree(){
		getResponse().setCharacterEncoding("UTF-8");
		try {
			SgUserInfo sgUserInfo = (SgUserInfo) getSession().getAttribute("user");
			if(sgUserInfo!=null){
				long pagerId=Long.parseLong(node);
				this.sgPagerInfos = sgPagerInfoService.findByParentId(pagerId);
				JSONArray jsonArray = new JSONArray();
				for(SgPagerInfo sgPagerInfo:this.sgPagerInfos){
					jsonArray.add(sgPagerInfo);
					getLog().info(sgPagerInfo.getText());
				}
				outJsonArray(jsonArray);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<SgPagerInfo> getSgPagerInfos() {
		return sgPagerInfos;
	}
	public void setSgPagerInfos(List<SgPagerInfo> sgPagerInfos) {
		this.sgPagerInfos = sgPagerInfos;
	}
	public SgPagerInfo getSgPagerInfo() {
		return sgPagerInfo;
	}
	public void setSgPagerInfo(SgPagerInfo sgPagerInfo) {
		this.sgPagerInfo = sgPagerInfo;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
}
