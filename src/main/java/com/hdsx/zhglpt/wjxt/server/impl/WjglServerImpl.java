package com.hdsx.zhglpt.wjxt.server.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hdsx.dao.query.base.BaseOperate;
import com.hdsx.zhglpt.wjxt.bean.Gcda;
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

	
	public boolean insertJhwj(Wjgl wjgl) {
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

	
	public boolean updateJhwj(Wjgl wjgl) {
		return update("updateQtwj", wjgl)==1;
	}
	
	
	public boolean deleteQtwj(Wjgl wjgl) {
		if(delete("deleteQtwj",wjgl)==1){
			delete("deleteWjfile1", wjgl.getId());
			return true;
		}
		return false;
	}

	
	public List<Wjgl> selectjhwjlist(Wjgl wjgl) {
		return queryList("selectjhwjlist",wjgl);
	}

	
	public int selectjhwjlistCount(Wjgl wjgl) {
		return queryOne("selectjhwjlistCount", wjgl);
	}

	
	public boolean deleteJhwj(Wjgl wjgl) {
		if(delete("deleteJhwj",wjgl)==1){
			delete("deleteWjfile1", wjgl.getId());
			return true;
		}
		return false;
	}

	
}
