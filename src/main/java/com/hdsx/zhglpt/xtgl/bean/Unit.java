package com.hdsx.zhglpt.xtgl.bean;

import java.io.Serializable;

/**
 * 鐢ㄦ埛瀹炰綋
 * 
 * @author wd
 * 
 */
public class Unit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3611109655157548249L;
	private String id;//鍗曚綅缂栫爜
	private String name;//鍗曚綅鍚嶇О
	private String _parentId;//涓婄骇鍗曚綅
	private String parent;//涓婄骇鍗曚綅
	private String unit;//琛屾斂鍖哄垝
	private String iconCls="icon-none";
	private String state="open";
	private String roadcode;
	private String roadstart;
	private String roadends;
	private String roadname;
	private String bmid;
	private String desr;
	/**
	 * page 褰撳墠鐨勯〉鏁�
	 * rows 鏄剧ず鐨勬潯鏁�
	 */
	private int page;
	private int rows;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String get_parentId() {
		return _parentId;
	}
	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	public String getDesr() {
		return desr;
	}
	public void setDesr(String desr) {
		this.desr = desr;
	}
	public String getRoadcode() {
		return roadcode;
	}
	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}
	public String getRoadstart() {
		return roadstart;
	}
	public void setRoadstart(String roadstart) {
		this.roadstart = roadstart;
	}
	public String getRoadends() {
		return roadends;
	}
	public void setRoadends(String roadends) {
		this.roadends = roadends;
	}
	public String getRoadname() {
		return roadname;
	}
	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
	
	
	
	

}
