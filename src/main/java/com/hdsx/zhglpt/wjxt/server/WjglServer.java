package com.hdsx.zhglpt.wjxt.server;

import java.util.List;
import java.util.Map;

import com.hdsx.zhglpt.wjxt.bean.Gcda;
import com.hdsx.zhglpt.wjxt.bean.GcdaZtjl;
import com.hdsx.zhglpt.wjxt.bean.Wjgl;

public interface WjglServer {

	boolean uploadWjFile(Wjgl wjgl);

	boolean deleteWjfile(Wjgl wjgl);

	boolean deleteWjfile1(String id);

	boolean insertZcwj(Wjgl wjgl);

	List<Wjgl> selectzcwjlist(Wjgl wjgl);
	
	List<GcdaZtjl> queryZjxdById(GcdaZtjl gcdaZtjl);
	int selectzcwjlistCount(Wjgl wjgl);

	List<Wjgl> selectWjfile(Wjgl wjgl);
	List<Wjgl> selectWjfileByWjid(Wjgl wjgl);

	Wjgl selectWjById(Wjgl wjgl);

	boolean updateZcwj(Wjgl wjgl);

	boolean deleteZcwj(Wjgl wjgl);

	boolean insertQtwj(Gcda wjgl);
	boolean addGcdaZtjl(GcdaZtjl gcdaZtjl);
	boolean delGcdaZtjlById(GcdaZtjl gcdaZtjl);
	boolean editGcdaZtjl(GcdaZtjl gcdaZtjl);
	

	List<Gcda> selectqtwjlist(Gcda wjgl);

	int selectqtwjlistCount(Gcda wjgl);

	boolean deleteQtWjfile1(String id);

	boolean updateQtwj(Gcda wjgl);

	boolean deleteQtwj(Wjgl wjgl);

	boolean insertJhwj(Wjgl wjgl);

	boolean updateJhwj(Wjgl wjgl);

	List<Wjgl> selectjhwjlist(Wjgl wjgl);

	int selectjhwjlistCount(Wjgl wjgl);

	boolean deleteJhwj(Wjgl wjgl);

}
