package com.banshan.lifebarServer.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.banshan.lifebarServer.common.LCFileAccess;
import com.banshan.lifebarServer.common.LifeBarDefination;
import com.banshan.lifebarServer.common.SystemStatic;
import com.banshan.lifebarServer.model.TblPic;
import com.banshan.lifebarServer.model.TblProduct;
import com.banshan.lifebarServer.model.TblTypeOfProduct;
import com.banshan.lifebarServer.service.OrgInfoService;
import com.banshan.lifebarServer.service.PicInfoService;
import com.banshan.lifebarServer.service.ProductInfoService;

public class ProductInfoAction extends BaseJsonAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8904370361481319422L;

	@Resource
	OrgInfoService orgInfoService;
	@Resource
	PicInfoService picInfoService;
	@Resource
	ProductInfoService productInfoService;

	private boolean fileUploaded = false;
	private long productId;
	private TblPic pic;
	private TblProduct product;
	private ArrayList<TblPic> picList;
	private String picPath;
	private short picTypeId;
	private int typeId;
	private String typeListString;
	private String picListString;
	private String picTypeListString;

	public String getPicListString()
	{
		return picListString;
	}

	public void setPicListString(String picListString)
	{
		this.picListString = picListString;
	}

	public String getPicTypeListString()
	{
		return picTypeListString;
	}

	public void setPicTypeListString(String picTypeListString)
	{
		this.picTypeListString = picTypeListString;
	}

	public String getTypeListString()
	{
		return typeListString;
	}

	public void setTypeListString(String typeListString)
	{
		this.typeListString = typeListString;
	}

	public short getPicTypeId()
	{
		return picTypeId;
	}

	public void setPicTypeId(short picTypeId)
	{
		this.picTypeId = picTypeId;
	}

	public int getTypeId()
	{
		return typeId;
	}

	public void setTypeId(int typeId)
	{
		this.typeId = typeId;
	}

	private List<TblTypeOfProduct> typeList;

	public List<TblTypeOfProduct> getTypeList()
	{
		return typeList;
	}

	public void setTypeList(List<TblTypeOfProduct> typeList)
	{
		this.typeList = typeList;
	}

	public boolean isFileUploaded()
	{
		return fileUploaded;
	}

	public void setFileUploaded(boolean fileUploaded)
	{
		this.fileUploaded = fileUploaded;
	}

	public long getProductId()
	{
		return productId;
	}

	public void setProductId(long productId)
	{
		this.productId = productId;
	}

	public TblProduct getProduct()
	{
		return product;
	}

	public void setProduct(TblProduct product)
	{
		this.product = product;
	}

	public ArrayList<TblPic> getPicList()
	{
		return picList;
	}

	public void setPicList(ArrayList<TblPic> picList)
	{
		this.picList = picList;
	}

	public String getPicPath()
	{
		return picPath;
	}

	public void setPicPath(String picPath)
	{
		this.picPath = picPath;
	}

	public String pics()
	{
		if (productId <= 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);

		}
		picList = (ArrayList<TblPic>) picInfoService.findPicsByRefIdAndRefType(
				productId, LifeBarDefination.LB_PIC_TYPE_PRODUCT);
		if (null == picList || picList.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_PRODUCT_NOPRODUCT);
		}
		setSuccessMessage("");
		return "pics";
	}

	public String types()
	{
		if (productId <= 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);

		}
		typeList = productInfoService.findAllTypesWithProductId(productId);
		if (null == typeList || typeList.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_PRODUCT_NOPRODUCT);
		}
		setSuccessMessage("");
		return "types";
	}

	public String picForType()
	{
		if (productId <= 0 || picTypeId < 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		pic = picInfoService.findPicByRefIdAndRefTypeAndType(productId,
				LifeBarDefination.LB_PIC_TYPE_PRODUCT, picTypeId);
		if (null == pic)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PRODUCT_NOPRODUCT);
		}
		setSuccessMessage("");
		return "picfortype";
	}

	public String addProductToType()
	{
		if (productId <= 0 || typeId < 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		productInfoService.addProductToType(productId, typeId);
		setSuccessMessage("");
		return SUCCESS;
	}

	public String dropTypeFromProduct()
	{
		if (productId <= 0 || typeId < 0)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		productInfoService.dropTypeFromProduct(productId, typeId);
		setSuccessMessage("");
		return SUCCESS;
	}

	public String updateTypes()
	{
		if (productId <= 0 || null == typeListString
				|| typeListString.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);

		}
		List<String> listInput = java.util.Arrays.asList(typeListString
				.split(","));
		List<TblTypeOfProduct> tmpList = productInfoService
				.findAllTypesWithProductId(productId);
		// 删除多余
		for (TblTypeOfProduct type : tmpList)
		{
			boolean beFinded = false;
			for (String typeIn : listInput)
			{
				if (Integer.parseInt(typeIn) == type.getTypeId())
				{
					beFinded = true;
					break;
				}
			}
			if (!beFinded)
			{
				productInfoService.dropTypeFromProduct(productId,
						type.getTypeId());
			}
		}
		// 增加
		for (String typeIn : listInput)
		{
			boolean beFinded = false;
			for (TblTypeOfProduct type : tmpList)
			{
				if (Integer.parseInt(typeIn) == type.getTypeId())
				{
					beFinded = true;
					break;
				}
			}
			if (!beFinded)
			{
				productInfoService.addProductToType(productId,
						Integer.parseInt(typeIn));
			}
		}
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

	public String addPic()
	{
		if (checkPic(pic))
		{
			if (true == fileUploaded)
			{
				// String imageFileName = new Date().getTime()
				// + LCFileAccess.getExtention(pic.getLink());
				// File imageFile = new File(ServletActionContext
				// .getServletContext().getRealPath(
				// LifeBarDefination.LB_PIC_RELATIVE_PATH)
				// + "/" + imageFileName);
				// String tmpFile = new File(
				// DefaultSettings.get("struts.multipart.saveDir") + "/"
				// + pic.getLink());

				String sour = ServletActionContext.getServletContext()
						.getRealPath(LifeBarDefination.LB_PIC_UPLOAD_PATH)
						+ "/" + pic.getLink();
				String dest = ServletActionContext.getServletContext()
						.getRealPath(LifeBarDefination.LB_PIC_RELATIVE_PATH)
						+ "/";
				if (LCFileAccess.move(sour, dest))
				{
					picInfoService.save(pic);
					pic.setId(null);
					setSuccessMessage("");
					return "addpic";
				} else
				{
					return setFailCode(SystemStatic.FAIL_FILE_COPY_ERROR);
				}
			}
			picInfoService.save(pic);
			pic.setId(null);
			setSuccessMessage("");
			return "addpic";
		}
		return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
	}

	public String updatePic()
	{
		if (checkPic(pic))
		{
			if (true == fileUploaded)
			{
				String sour = ServletActionContext.getServletContext()
						.getRealPath(LifeBarDefination.LB_PIC_UPLOAD_PATH)
						+ "/" + pic.getLink();
				String dest = ServletActionContext.getServletContext()
						.getRealPath(LifeBarDefination.LB_PIC_RELATIVE_PATH)
						+ "/";
				if (LCFileAccess.move(sour, dest))
				{
					picInfoService.update(pic);
					pic.setId(null);
					setSuccessMessage("");
					return "addpic";
				} else
				{
					return setFailCode(SystemStatic.FAIL_FILE_COPY_ERROR);
				}
			}
			picInfoService.update(pic);
			pic.setId(null);
			setSuccessMessage("");
			return "updatepic";
		}
		return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
	}

	private boolean updatePic(long productId, short picTypeId, String picLink)
	{
		String sour = ServletActionContext.getServletContext()
				.getRealPath(LifeBarDefination.LB_PIC_UPLOAD_PATH)
				+ "/" + picLink;
		String dest = ServletActionContext.getServletContext()
				.getRealPath(LifeBarDefination.LB_PIC_RELATIVE_PATH)
				+ "/";
		TblPic pic = picInfoService.findPicByRefIdAndRefTypeAndType(productId,
				LifeBarDefination.LB_PIC_TYPE_PRODUCT, picTypeId);
		if (null != pic)
		{
			pic.setLink(picLink);
			if (LCFileAccess.move(sour, dest))
			{
				picInfoService.update(pic);
				return true;
			}
		}
		return false;
	}

	private boolean addPic(long productId, short picTypeId, String picLink)
	{
		String sour = ServletActionContext.getServletContext()
				.getRealPath(LifeBarDefination.LB_PIC_UPLOAD_PATH)
				+ "/" + picLink;
		String dest = ServletActionContext.getServletContext()
				.getRealPath(LifeBarDefination.LB_PIC_RELATIVE_PATH)
				+ "/";
		TblPic pic = new TblPic();
		pic.setLink(picLink);
		pic.setRefId(productId);
		pic.setRefType(LifeBarDefination.LB_PIC_TYPE_PRODUCT);
		pic.setType(picTypeId);
		if (LCFileAccess.move(sour, dest))
		{
			picInfoService.save(pic);
			pic.setId(null);
			return true;
		}
		return false;
	}

	public String updatePics()
	{
		if (productId <= 0 || null == picListString
				|| null == picTypeListString || picListString.isEmpty()
				|| picTypeListString.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		String[] listPicInput = picListString.split(",");
		String[] listPicTypeInput = picTypeListString.split(",");
		if (listPicInput.length <= 0
				|| listPicInput.length != listPicTypeInput.length)
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		int len = listPicInput.length;
		List<TblPic> tmpList = picInfoService.findPicsByRefIdAndRefType(
				productId, LifeBarDefination.LB_PIC_TYPE_PRODUCT);
		// 删除多余
		for (TblPic pic : tmpList)
		{
			boolean beFinded = false;
			for (int i = 0; i < len; i++)
			{
				if (Short.parseShort(listPicTypeInput[i]) == pic.getType())
				{
					beFinded = true;
					if (!listPicInput[i].equals(pic.getLink()))
					{
						if (!updatePic(productId,
								Short.parseShort(listPicTypeInput[i]),
								listPicInput[i]))
						{
							getLog().error("update pic error!");
						}
					}
					break;
				}
			}
			if (!beFinded)
			{
				picInfoService.delete(pic.getId());
			}
		}
		// 增加
		for (int i = 0; i < len; i++)
		{
			boolean beFinded = false;
			for (TblPic pic : tmpList)
			{
				if (Short.parseShort(listPicTypeInput[i]) == pic.getType())
				{
					beFinded = true;
					break;
				}
			}
			if (!beFinded)
			{
				if (!addPic(productId, Short.parseShort(listPicTypeInput[i]),
						listPicInput[i]))
				{
					getLog().error("add pic error!");
				}
			}
		}
		setSuccessMessage("");
		return SUCCESS;
	}

	public TblPic getPic()
	{
		return pic;
	}

	public void setPic(TblPic pic)
	{
		this.pic = pic;
	}

	private boolean checkPic(TblPic pic)
	{
		if (null == pic)
		{
			return false;
		}
		if (null == pic.getRefId() || null == pic.getRefType()
				|| null == pic.getType() || pic.getRefId() <= 0
				|| pic.getRefType() < 0 || pic.getType() < 0)
		{
			return false;
		}
		if (false == fileUploaded)
		{
			if (null == pic.getLink())
			{
				pic.setLink("");
			}
		} else
		{
			if (null == pic.getLink() || pic.getLink().isEmpty())
			{
				return false;
			}
		}
		return true;
	}

}
