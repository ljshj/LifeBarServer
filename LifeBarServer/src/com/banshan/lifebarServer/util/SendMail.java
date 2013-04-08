package com.banshan.lifebarServer.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;
public class SendMail 
{
	private String smtpserver = ""; //stmp������ 
	private String mailto = ""; //�����ߵ�����  
	private String mailfrom = ""; //���͵�����  
	private String account = "";  //����������ʺ�
	private String password = ""; //������������� 
	private String title = "";  //�ʼ�����
	private String content = "";  //�ʼ�����
	public SendMail(){}
	public boolean sendEmail()
	{
		boolean flag=false;
		try
		{ 
	         Properties props = System.getProperties();  
	         props.put("mail.smtp.host", smtpserver);  
	         props.put("mail.smtp.auth", "true");  
	         javax.mail.Session mailSession = javax.mail.Session.getInstance(props, null);  

	         Message msg = new MimeMessage(mailSession);  
	         msg.setFrom(new InternetAddress(mailfrom));  
	         msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailto, false)); //�����ߵ�����  
	         msg.setSubject(title); 
	         msg.setText(content); 
	         msg.setHeader("X-Mailer", "smtpsend");  
	         msg.setSentDate(new java.util.Date());  
	         SMTPTransport t = (SMTPTransport)mailSession.getTransport("smtp");  
	         t.connect(smtpserver, account, password);  
	         t.sendMessage(msg, msg.getAllRecipients());  
	         t.close(); 
	         flag=true;
	     }
		catch(Exception e)
		{  
	          flag = false;  
	          e.printStackTrace(); 
	     } 
	     return flag;
	}
	public void setHost(String host)
	{
		this.smtpserver=host;
	}
	public String getHost()
	{
		return this.smtpserver;
	}
	public void setMailto(String mailto)
	{
		this.mailto=mailto;
	}
	public String getMialto()
	{
		return this.mailto;
	}
	public void setMailfrom(String mailfrom)
	{
		this.mailfrom=mailfrom;
	}
	public String getMailfrom()
	{
		return this.mailfrom;
	}
	public void setAccount(String account)
	{
		this.account=account;
	}
	public String getAccount()
	{
		return this.account;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getContent()
	{
		return this.content;
	}
}
