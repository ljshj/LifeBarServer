package com.banshan.lifebarServer.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.banshan.lifebarServer.common.LCFileAccess;
import com.banshan.lifebarServer.common.LifeBarDefination;
import com.banshan.lifebarServer.common.SystemStatic;
import com.banshan.lifebarServer.model.TblPic;
import com.banshan.lifebarServer.service.PicInfoService;

public class FileUploadAction extends BaseJsonAction
{

	private static final long serialVersionUID = 572146812454l;

	@Resource
	PicInfoService picInfoService;
	
	private File myFile;
	private String contentType;
	private String fileName;
	private String imageFileName;
	private String caption;
	private String tmpFilePath;
	
	private String picListString;
	private String picTypeListString;
	private short picRefType = -1;
	private long refId = -1;
	private List<TblPic> picList;
	public List<TblPic> getPicList()
	{
		return picList;
	}

	public void setPicList(List<TblPic> picList)
	{
		this.picList = picList;
	}

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

	public short getPicRefType()
	{
		return picRefType;
	}

	public void setPicRefType(short picRefType)
	{
		this.picRefType = picRefType;
	}

	public long getRefId()
	{
		return refId;
	}

	public void setRefId(long refId)
	{
		this.refId = refId;
	}


	public String getTmpFilePath()
	{
		return tmpFilePath;
	}

	public void setTmpFilePath(String tmpFilePath)
	{
		this.tmpFilePath = tmpFilePath;
	}

	public void setMyFileContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public void setMyFileFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public void setMyFile(File myFile)
	{
		this.myFile = myFile;
	}

	public String getImageFileName()
	{
		return imageFileName;
	}

	public String getCaption()
	{
		return caption;
	}

	public void setCaption(String caption)
	{
		this.caption = caption;
	}

	@Override
	public String execute()
	{

		if (null != myFile)
		{
			String imageFileName = new Date().getTime()
					+ LCFileAccess.getExtention(fileName);
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath(LifeBarDefination.LB_PIC_UPLOAD_PATH)
					+ "/"
					+ imageFileName);
			LCFileAccess.copy(myFile, imageFile);
			tmpFilePath = imageFile.getName();
		}
		setSuccessMessage("");
		return SUCCESS;
	}
	
	private boolean updatePic(long productId, short picTypeId, short picRefType, String picLink)
	{
		String sour = ServletActionContext.getServletContext()
				.getRealPath(LifeBarDefination.LB_PIC_UPLOAD_PATH)
				+ "/" + picLink;
		String dest = ServletActionContext.getServletContext()
				.getRealPath(LifeBarDefination.LB_PIC_RELATIVE_PATH)
				+ "/";
		TblPic pic = picInfoService.findPicByRefIdAndRefTypeAndType(productId,
				picRefType, picTypeId);
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

	private boolean addPic(long productId, short picTypeId, short picRefType, String picLink)
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
		pic.setRefType(picRefType);
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
		if (refId <= 0 || picRefType < 0 || null == picListString
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
				refId, picRefType);
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
						if (!updatePic(refId,
								Short.parseShort(listPicTypeInput[i]),
								picRefType, listPicInput[i]))
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
				if (!addPic(refId, Short.parseShort(listPicTypeInput[i]),
						picRefType, listPicInput[i]))
				{
					getLog().error("add pic error!");
				}
			}
		}
		setSuccessMessage("");
		return SUCCESS;
	}
	
	public String pics()
	{
		if (refId <= 0 || picRefType < 0 )
		{
			return setFailCode(SystemStatic.FAIL_CODE_PARAM_ERROR);
		}
		
		picList = (ArrayList<TblPic>) picInfoService.findPicsByRefIdAndRefType(
					refId, picRefType);		
		if (null == picList || picList.isEmpty())
		{
			return setFailCode(SystemStatic.FAIL_CODE_ORG_NOPIC);
		}
		setSuccessMessage("");
		return "pics";
	}
}
