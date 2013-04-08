package com.banshan.lifebarServer.action;

import java.io.File;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.banshan.lifebarServer.common.LCFileAccess;
import com.banshan.lifebarServer.common.LifeBarDefination;

public class FileUploadAction extends BaseJsonAction
{

	private static final long serialVersionUID = 572146812454l;

	private File myFile;
	private String contentType;
	private String fileName;
	private String imageFileName;
	private String caption;
	private String tmpFilePath;

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
}
