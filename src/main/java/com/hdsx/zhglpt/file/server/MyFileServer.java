package com.hdsx.zhglpt.file.server;

import java.util.List;

import com.hdsx.zhglpt.file.bean.MyFile;

public interface MyFileServer {
	public Boolean insertFile(MyFile my); 
	public List<MyFile> selectFiles(MyFile my);
	public Boolean deleteFile(MyFile my);
}
