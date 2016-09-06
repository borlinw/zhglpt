package com.hdsx.zhglpt.wjxt.server.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hdsx.dao.query.base.BaseOperate;
import com.hdsx.zhglpt.wjxt.bean.Bgda;
import com.hdsx.zhglpt.wjxt.bean.Gcda;
import com.hdsx.zhglpt.wjxt.bean.GcdaZtjl;
import com.hdsx.zhglpt.wjxt.bean.Wjgl;
import com.hdsx.zhglpt.wjxt.server.WjglServer;

@Service
public class WjglServerImpl extends BaseOperate implements WjglServer {

	public WjglServerImpl() {
		super("wjgl", "jdbc");
	}

	public boolean uploadWjFile(Wjgl wjgl) {
		return insert("uploadWjFile", wjgl)==1;
	}

	
	public boolean deleteWjfile(Wjgl wjgl) {
		return delete("deleteWjfile", wjgl)==1;
	}

	
	public boolean deleteWjfile1(String id) {
		Wjgl wjgl=queryOne("selectzcwjbyid", id);
		if(wjgl==null)
		delete("deleteWjfile1",id);
		return true;
	}

	
	public boolean insertZcwj(Wjgl wjgl) {
		return insert("insertZcwj", wjgl)==1;
	}

	
	public List<Wjgl> selectzcwjlist(Wjgl wjgl) {
		return queryList("selectzcwjlist", wjgl);
	}

	
	public int selectzcwjlistCount(Wjgl wjgl) {
		return queryOne("selectzcwjlistCount", wjgl);
	}

	
	public List<Wjgl> selectWjfile(Wjgl wjgl) {
		return queryList("selectWjfile",wjgl);
	}
	public List<Wjgl> selectWjfileByWjid(Wjgl wjgl) {
		return queryList("selectWjfileByWjid",wjgl);
	}
	
	
	public Wjgl selectWjById(Wjgl wjgl) {
		// TODO Auto-generated method stub
		return queryOne("selectWjById", wjgl);
	}

	
	public boolean updateZcwj(Wjgl wjgl) {
		// TODO Auto-generated method stub
		return update("updateZcwj", wjgl)==1;
	}

	
	public boolean deleteZcwj(Wjgl wjgl) {
		if(delete("deleteZcwj",wjgl)==1){
			delete("deleteWjfile1", wjgl.getId());
			return true;
		}
		return false;
	}

	
	public boolean insertQtwj(Gcda wjgl) {
		return insert("insertQtwj", wjgl)==1;
	}

	
	public boolean insertJhwj(Bgda wjgl) {
		return insert("insertJhwj", wjgl)==1;
	}
	
	
	public List<Gcda> selectqtwjlist(Gcda wjgl) {
		return queryList("selectqtwjlist", wjgl);
	}

	
	public int selectqtwjlistCount(Gcda wjgl) {
		return queryOne("selectqtwjlistCount", wjgl);
	}

	
	public boolean deleteQtWjfile1(String id) {
		Wjgl wjgl=queryOne("selectqtwjbyid", id);
		if(wjgl==null)
		delete("deleteWjfile1",id);
		return true;
	}

	
	public boolean updateQtwj(Gcda wjgl) {
		return update("updateQtwj", wjgl)==1;
	}

	
	public boolean updateJhwj(Bgda wjgl) {
		return update("updateJhwj", wjgl)==1;
	}
	
	
	public boolean deleteQtwj(Wjgl wjgl) {
		if(delete("deleteQtwj",wjgl)==1){
			delete("deleteWjfile1", wjgl.getId());
			return true;
		}
		return false;
	}

	
	public List<Bgda> selectjhwjlist(Bgda wjgl) {
		return queryList("selectjhwjlist",wjgl);
	}

	
	public int selectjhwjlistCount(Bgda wjgl) {
		return queryOne("selectjhwjlistCount", wjgl);
	}

	
	public boolean deleteJhwj(Wjgl wjgl) {
		if(delete("deleteJhwj",wjgl)==1){
			delete("deleteWjfile1", wjgl.getId());
			return true;
		}
		return false;
	}

	public List<GcdaZtjl> queryZjxdById(GcdaZtjl gcdaZtjl) {
		// TODO Auto-generated method stub
		return queryList("queryZjxdById",gcdaZtjl);
	}

	public boolean addGcdaZtjl(GcdaZtjl gcdaZtjl) {
		// TODO Auto-generated method stub
		return insert("addGcdaZtjl", gcdaZtjl)==1;	
		}

	public boolean delGcdaZtjlById(GcdaZtjl gcdaZtjl) {
		// TODO Auto-generated method stub
		int i=delete("delGcdaZtjlById", gcdaZtjl);
		System.out.println("i========"+i);
		return i==1;
	}

	public boolean editGcdaZtjl(GcdaZtjl gcdaZtjl) {
		// TODO Auto-generated method stub
		return insert("editGcdaZtjl", gcdaZtjl)==1;	
	}
	
}
