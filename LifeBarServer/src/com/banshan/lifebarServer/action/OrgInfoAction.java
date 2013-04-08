package com.banshan.lifebarServer.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.banshan.lifebarServer.common.LifeBarDefination;
import com.banshan.lifebarServer.common.SystemStatic;
import com.banshan.lifebarServer.model.TblCompany;
import com.banshan.lifebarServer.model.TblCompanyConf;
import com.banshan.lifebarServer.model.TblProduct;
import com.banshan.lifebarServer.model.TblProductType;
import com.banshan.lifebarServer.service.DiscountCardInfoService;
import com.banshan.lifebarServer.service.OrgConfService;
import com.banshan.lifebarServer.service.OrgInfoService;
import com.banshan.lifebarServer.service.PicInfoService;
import com.banshan.lifebarServer.service.ProductInfoService;
import com.banshan.lifebarServer.service.ProductTypeInfoService;

public class OrgInfoAction extends BaseJsonAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4738376085416414592L;

	@Resource
	OrgInfoService orgInfoService;
	@Resource
	PicInfoService picInfoService;
	@Resource
	DiscountCardInfoService discountCardInfoService;
	@Resource
	ProductInfoService productInfoService;
	@Resource
	ProductTypeInfoService productTypeInfoService;
	@Resource
	OrgConfService orgConfSerivce;

	private TblCompany org;
	private String orgAccount;
	private String password;
	private int typeId = 0;
	private int orgId = 0;
	private int offset = 0;
	private int pagesize = 0;
	private TblProduct product;
	private ArrayList<TblProduct> productList;
	private String picPath;
	private ArrayList<TblProductType> productTypeList;
	private ArrayList<TblCompanyConf> orgConfList;
	private TblProductType productType;
	private String confKey;
	private String confValue;
	private long productId = 0;

	public long getProductId()
	{
		return productId;
	}

	public void setProductId(long productId)
	{
		this.productId = productId;
	}

	public String getConfKey()
	{
		return confKey;
	}

	public void setConfKey(String confKey)
	{
		this.confKey = confKey;
	}

	public String getConfValue()
	{
		return confValue;
	}

	public void setConfValue(String confValue)
	{
		this.confValue = confValue;
	}

	public TblProductType getProductType()
	{
		return productType;
	}

	public void setProductType(TblProductType productType)
	{
		this.productType = productType;
	}

	public ArrayList<TblCompanyConf> getOrgConfList()
	{
		return orgConfList;
	}

	public void setOrgConfList(ArrayList<TblCompanyConf> orgConfList)
	{
		this.orgConfList = orgConfList;
	}

	public ArrayList<TblProductType> getProductTypeList()
	{
		return productTypeList;
	}

	public void setProductTypeList(ArrayList<TblProductType> productTypeList)
	{
		this.productTypeList = productTypeList;
	}

	public int getTypeId()
	{
		return typeId;
	}

	public void setTypeId(int typeId)
	{
		this.typeId = typeId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPicPath()
	{
		return picPath;
	}

	public void setPicPath(String picPath)
	{
		this.picPath = picPath;
	}

	public ArrayList<TblProduct> getProductList()
	{
		return productList;
	}

	public void setProductList(ArrayList<TblProduct> productList)
	{
		this.productList = productList;
	}

	public int getOffset()
	{
		return offset;
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public int getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(int pagesize)
	{
		this.pagesize = pagesize;
	}

	public TblCompany getOrg()
	{
		return org;
	}

	public void setOrg(TblCompany org)
	{
		this.org = org;
	}

	public String getOrgAccount()
	{
		return orgAccount;
	}

	public void setOrgAccount(String orgAccount)
	{
		this.orgAccount = orgAccount;
	}

	public String login()
	{
		org = orgInfoService.findOrgByAccount(orgAccount);
		if (org == null || !org.getCpwd().equals(password))
		{
			return setFailCode(SystemStatic.FAIL_CODE_USER_LOGINFAIL);
		}
		orgConfList = (ArrayList<TblCompanyConf>) orgConfSerivce
				.findConfByOrgId(org.getCompanyId());
		setSuccessMessage("");
		return "orginfo";
	}

	public String orgInfo()
	{
		org = orgInfoService.findOrgByAccount(orgAccount);
		if (null == org)
		{
			return setFailCode(SystemStatic.FAIL_CODE_ORG_NOEXIST);
		}
		orgConfList = (ArrayList<TblCompanyConf>) orgConfSerivce
				.findConfByOrgId(org.getCompanyId());
		setSuccessMessage("");
		return "orginfo";
	}

	public String productTypes()
	{
		if (orgId <= 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		productTypeList = (ArrayList<TblProductType>) productTypeInfoService
				.findProductTypeByOrgId(orgId);
		setSuccessMessage("");
		return "producttypes";
	}

	public String deleteProductType()
	{
		if (typeId <= 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		productTypeInfoService.delete(typeId);
		setSuccessMessage("");
		return SUCCESS;
	}

	public String addProductType()
	{
		if (checkProductTypeWithoutTypeId(productType))
		{
			productTypeInfoService.save(productType);
			productType.setTypeId(null);
			setSuccessMessage("");
			return SUCCESS;
		}
		return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);

	}

	public String updateProductType()
	{
		if (checkProductType(productType))
		{
			productTypeInfoService.update(productType);
			setSuccessMessage("");
			return SUCCESS;
		}
		return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
	}
	
	public String updateOrgConf()
	{
		if (orgId <= 0 || null == confKey || null == confValue || confKey.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		orgConfSerivce.update(orgId, confKey, confValue);
		setSuccessMessage("");
		return SUCCESS;
	}
	
	public String addOrgConf()
	{
		if (orgId <= 0 || null == confKey || null == confValue || confKey.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		TblCompanyConf conf = new TblCompanyConf();
		conf.setCompanyId(orgId);
		conf.setName(confKey);
		conf.setValue(confValue);
		orgConfSerivce.save(conf);
		setSuccessMessage("");
		return SUCCESS;
	}

	public String products()
	{
		if (offset < 0 || pagesize <= 0 || ((null == orgAccount
				|| orgAccount.isEmpty()) && orgId <= 0))
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		if (orgId <= 0)
		{
			org = orgInfoService.findOrgByAccount(orgAccount);
			if (null == org)
			{
				return setFailCode(SystemStatic.FAIL_CODE_ORG_NOEXIST);
			}
			orgId = org.getCompanyId();
		}
		if (typeId <= 0)
		{
			productList = (ArrayList<TblProduct>) productInfoService
					.findProductsByOrgId(orgId, offset, pagesize);

		} else
		{
			productList = (ArrayList<TblProduct>) productInfoService
					.findProductsByOrgIdWithTypeId(orgId, typeId,
							offset, pagesize);
		}
		if (null == productList || productList.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_ORG_NOPRODUCT);
		}
		setSuccessMessage("");
		return "products";
	}

	public String addProduct()
	{
		if (checkProduct(product))
		{
			Timestamp appointTime = Timestamp.valueOf(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").format(new Date()));
			product.setEffdate(appointTime);
			product.setExpdate(new Timestamp(appointTime.getTime() + 1000 * 60
					* 60 * 24 * 365));
			if (null == product.getPriority())
			{
				product.setPriority(LifeBarDefination.LB_PRODUCT_PRIORITY_DEFAULT);
			}
			productInfoService.save(product);
			productId = product.getProductId();
			product.setProductId(null);
			setSuccessMessage("");
			return "addproduct";
		}
		return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);

	}

	public String updateProduct()
	{
		if (checkProduct(product))
		{
			productInfoService.update(product);
			setSuccessMessage("");
			return "updateproduct";
		}
		return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
	}
	public String deleteProduct()
	{
		if (productId <= 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		productInfoService.delete(productId);
		setSuccessMessage("");
		return SUCCESS;
	}
	public String picPath()
	{
		HttpServletRequest request = getRequest();
		picPath = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath()
				+ LifeBarDefination.LB_PIC_RELATIVE_PATH;
		setSuccessMessage("");
		return "picpath";
	}

	public int getOrgId()
	{
		return orgId;
	}

	public void setOrgId(int orgId)
	{
		this.orgId = orgId;
	}

	public TblProduct getProduct()
	{
		return product;
	}

	public void setProduct(TblProduct product)
	{
		this.product = product;
	}

	private Boolean checkProduct(TblProduct product)
	{
		if (null == product)
		{
			return false;
		}
		if (null == product.getName() || null == product.getOrgid()
				|| null == product.getAmount() || null == product.getPrice()
				|| null == product.getType() || product.getName().isEmpty()
				|| product.getOrgid() <= 0 || product.getAmount() < 0
				|| product.getPrice() < 0 || product.getType() < 0)
		{
			return false;
		}
		return true;
	}

	private boolean checkProductType(TblProductType productType)
	{
		if (!checkProductTypeWithoutTypeId(productType) || productType.getTypeId() < 0)
		{
			return false;
		}
		return true;
	}
	private boolean checkProductTypeWithoutTypeId(TblProductType productType)
	{
		if (null == productType)
		{
			return false;
		}
		if (productType.getParent() < 0 || productType.getOrgId() <= 0
				|| null == productType.getName()
				|| productType.getName().isEmpty())
		{
			return false;
		}
		return true;
	}
}
