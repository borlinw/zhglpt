package com.hdsx.zhglpt.wjxt.bean;

import java.io.Serializable;
import java.util.Date;

public class Gcda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String xmmc;
	private String damc;
	private String bzdw;
	private String lb;
	private String rq;
	private String cs;
	
	private String bz;
	private String cfwz;
	private String kssj;
	private String jssj;
	private int page;
	private int rows;
	
	public String getKssj() {
		return kssj;
	}
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getDamc() {
		return damc;
	}
	public void setDamc(String damc) {
		this.damc = damc;
	}
	public String getBzdw() {
		return bzdw;
	}
	public void setBzdw(String bzdw) {
		this.bzdw = bzdw;
	}
	public String getLb() {
		return lb;
	}
	public void setLb(String lb) {
		this.lb = lb;
	}
	public String getRq() {
		return rq;
	}
	public void setRq(String rq) {
		this.rq = rq;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	public String getCfwz() {
		return cfwz;
	}
	public void setCfwz(String cfwz) {
		this.cfwz = cfwz;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
