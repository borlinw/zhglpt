package com.hdsx.zhglpt.wjxt.bean;

import java.io.Serializable;
import java.util.Date;

public class GcdaZtjl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String daid;
	private String jcr;
	private String jcsj;
	private String jclxdh;
	private String ghr;
	private String ghsj;
	
	private String ghlxdh;
	private String bz;
	private int page;
	private int rows;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDaid() {
		return daid;
	}

	public void setDaid(String daid) {
		this.daid = daid;
	}

	public String getJcr() {
		return jcr;
	}

	public void setJcr(String jcr) {
		this.jcr = jcr;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getJclxdh() {
		return jclxdh;
	}

	public void setJclxdh(String jclxdh) {
		this.jclxdh = jclxdh;
	}

	public String getGhr() {
		return ghr;
	}

	public void setGhr(String ghr) {
		this.ghr = ghr;
	}

	public String getGhsj() {
		return ghsj;
	}

	public void setGhsj(String ghsj) {
		this.ghsj = ghsj;
	}

	public String getGhlxdh() {
		return ghlxdh;
	}

	public void setGhlxdh(String ghlxdh) {
		this.ghlxdh = ghlxdh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
}
