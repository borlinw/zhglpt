package com.hdsx.zhglpt.file.server.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hdsx.dao.query.base.BaseOperate;
import com.hdsx.zhglpt.file.bean.MyFile;
import com.hdsx.zhglpt.file.server.MyFileServer;
@Service
public class MyFileServerImp  extends BaseOperate implements MyFileServer{
	public MyFileServerImp() {
		super(MyFile.class, "jdbc");
		// TODO Auto-generated constructor stub
	}

	
	public Boolean insertFile(MyFile my)
	{
		System.out.println("------------------");
		if(insert("insertFile",my)>0)
		{
			System.out.println("--------true---------");
			 return true;
		}
		else
		{
			System.out.println("--------false----------");
			return false;
		}
	}

	
	public List<MyFile> selectFiles(MyFile my) {
		return  queryList("selectFile",my);
		
	}

	
	public Boolean deleteFile(MyFile my) {
		
		if(delete("deleteFile",my)>0)
		{
			return true;
		}
		else
		{return false;}
	}

	
	
	
}
