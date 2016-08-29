package com.hdsx.zhglpt.file.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;

import com.hdsx.zhglpt.file.bean.MyFile;
import com.hdsx.zhglpt.file.server.MyFileServer;
import com.hdsx.zhglpt.utile.ResponseUtils;
import com.hdsx.webutil.struts.BaseActionSupport;
@Controller
public class FileUploadController extends BaseActionSupport{

	/**
	 * �ļ��ϴ�
	 */
	private static final long serialVersionUID = 1L;
	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;
	private String xmid; 
	@Resource(name="myFileServerImp")
	public MyFileServer fileserver;
	public String uploadfiles(){

		try
		{
		
			String filepath=PropertiesReader.getInstance().getFileUrl();
			for (int i = 0; i < upload.length; i++)
			{
				String fileName = uploadFileName[i];
				String type = uploadContentType[i];
				String realName = UUID.randomUUID().toString()+ getExt(fileName);
				File target = new File(filepath, realName);
				FileUtils.copyFile(upload[i], target);
				MyFile my=new MyFile();
				my.setFileName(realName);
				my.setRealName(fileName);
				my.setXmid(xmid);
				System.out.println(xmid+"--------xmid--------");
				Date date=new Date();
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String sss=df.format(date);
				my.setUploadtime(sss);
				my.setUrl(filepath+"/"+fileName);
				System.out.println(filepath+"/"+fileName+"------------------");
				Boolean bool=fileserver.insertFile(my);
				ResponseUtils.write(getresponse(), bool+"");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String getXmid() {
		return xmid;
	}
	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	public static String getExt(String fileName)
	{
		return fileName.substring(fileName.lastIndexOf("."));
	}
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}
