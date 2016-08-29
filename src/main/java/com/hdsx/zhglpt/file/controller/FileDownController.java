package com.hdsx.zhglpt.file.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.hdsx.zhglpt.file.bean.MyFile;
import com.hdsx.zhglpt.file.server.MyFileServer;
import com.hdsx.zhglpt.utile.EasyUIPage;
import com.hdsx.zhglpt.utile.JsonUtils;
import com.hdsx.zhglpt.utile.ResponseUtils;
import com.hdsx.webutil.struts.BaseActionSupport;


@Controller
public class FileDownController extends BaseActionSupport
{
	private static final long serialVersionUID = 6329383258366253255L;
	private String fileName;
	private String realName;
	
	@Resource(name="myFileServerImp")
	public MyFileServer fileserver;
	private String xmid;
	private String id;

	public void getFileNames(){
		MyFile my=new MyFile();
		my.setXmid(xmid);
		
		List<MyFile> files=fileserver.selectFiles(my);
		System.out.println(xmid+"--------"+files.size());
		EasyUIPage<MyFile> ep=new EasyUIPage<MyFile>();
		ep.setRows(files);
		try {
			JsonUtils.write(ep, getresponse().getWriter());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	public void deleteFile(){
		MyFile my=new MyFile();
		my.setId(id);
		System.out.println(id+"------------"+fileName);
		Boolean bool=null;
		Boolean bool1=fileserver.deleteFile(my);
		File file=new File(PropertiesReader.getInstance().getFileUrl().trim()+"/" + fileName);
		Boolean bool2=file.delete();
		bool=bool1=bool2;
		ResponseUtils.write(getresponse(), bool+"");
	}
	
	
	public String getRealName() {
		System.out.println(xmid+"---------");
		MyFile my=new MyFile();
		my.setXmid(xmid);
		List<MyFile> files=fileserver.selectFiles(my);
		MyFile mf = files.get(0);
		String reanlname = mf.getRealName();
		try {
			realName = new String(reanlname.getBytes(),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//realName=ServletActionContext.getRequest().getParameter("realname");
		return realName;
	}
	public InputStream getDownloadFile()
	{
		System.out.println(xmid+"---------");
		MyFile my=new MyFile();
		my.setXmid(xmid);
		List<MyFile> files=fileserver.selectFiles(my);
		MyFile mf = files.get(0);
		this.realName = mf.getRealName();
		String fileName = mf.getFileName();
		
		//InputStream in= ServletActionContext.getServletContext().getResourceAsStream("/"+PropertiesReader.getInstance().getFileUrl().trim()+"/" + "附件.rar");
		File file=new File(PropertiesReader.getInstance().getFileUrl().trim()+"/" + fileName);
		System.out.println("PropertiesReader.getInstance().getFileUrl()::::" +PropertiesReader.getInstance().getFileUrl().trim()+"/" + fileName);
		InputStream in=null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;   
	}
	
	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MyFileServer getFileserver() {
		return fileserver;
	}
	public void setFileserver(MyFileServer fileserver) {
		this.fileserver = fileserver;
	}
	public String getXmid() {
		return xmid;
	}
	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}