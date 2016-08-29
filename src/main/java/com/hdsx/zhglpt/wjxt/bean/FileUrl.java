package com.hdsx.zhglpt.wjxt.bean;
/**
 * 
 * @author Administrator
 *文件上传
 */
public class FileUrl {
	public FileUrl() {
		super();
	}
	public FileUrl(String id,String filename, String wjtype,
			String wjid, String fileurl) {
		super();
		this.id=id;
		this.filename = filename;
		this.wjtype = wjtype;
		this.wjid = wjid;
		this.fileurl = fileurl;
	}
	private String id;
	private String fid;//文件ID
	private String wjid;//项目编码
	private String filename;
	private String wjtype;
	private String fileurl;//文件路径
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getWjid() {
		return wjid;
	}
	public void setWjid(String wjid) {
		this.wjid = wjid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getWjtype() {
		return wjtype;
	}
	public void setWjtype(String wjtype) {
		this.wjtype = wjtype;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

}
