package com.hdsx.zhglpt.xtgl.server.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hdsx.dao.query.base.BaseOperate;
import com.hdsx.zhglpt.utile.AnyChartUtil;
import com.hdsx.zhglpt.xtgl.bean.Bzbz;
import com.hdsx.zhglpt.xtgl.bean.Master;
import com.hdsx.zhglpt.xtgl.bean.Param;
import com.hdsx.zhglpt.xtgl.bean.Plan_flwbzbz;
import com.hdsx.zhglpt.xtgl.bean.TreeNode;
import com.hdsx.zhglpt.xtgl.bean.Unit;
import com.hdsx.zhglpt.xtgl.bean.Yhdzxcs;
import com.hdsx.zhglpt.xtgl.server.XtglServer;

@Service
public class XtglServerImpl extends BaseOperate  implements XtglServer{

	public XtglServerImpl() {
		super("xtgl", "jdbc");
	}
	
	
	public boolean czPassword(Master master) {
		int i = update("czPassword",master);
		if(i>=0) return true;
		return false;
	}

	
	public List<TreeNode> seldw(String yhdw) {
		return  queryList("seldw",yhdw);
	}

	
	public List<TreeNode> selchildedw(String yhdw) {
		return  queryList("selchildedw",yhdw);
	}

	
	public boolean updatePassword(HashMap hm) {
		if (update("updatePassword", hm) > 0) {
			return true;
		} else {
			return false;
		}
	}

	
	public HashMap<String, String> login(HashMap hm) {
		HashMap lhm=queryOne("loginnum",hm);
		return lhm;
	}

	
	public List<TreeNode> selAllXzqh2(String yhdw) {
		return queryList("selAllXzqh2",yhdw);
	}

	
	public List<TreeNode> selAllXzqh(String yhdw) {
		return queryList("selAllXzqh",yhdw);
	}

	
	public int selectYhListCount(HashMap hm) {
		return queryOne("selectYhListCount", hm);
	}

	
	public List<Master> selectYhList(HashMap hm) {
		return queryList("selectYhList", hm);
	}

	
	public List<HashMap> selQxList(HashMap hm) {
		return queryList("selQxList", hm);
	}

	
	public boolean insertYh(Master master) {
		int b=insert("insertYh", master);
		return b>0?true:false;
	}

	
	public boolean updatezt(HashMap hm) {
		int b=update("updatezt", hm);
		return b>0?true:false;
	}

	
	public boolean deleteYh(String id) {
		int b=delete("deleteYh",id);
		return b>0?true:false;
	}

	
	public boolean mimareset(HashMap hm) {
		int b=update("mimareset", hm);
		return b>0?true:false;
	}

	
	public boolean updateYh(Master master) {
		int b=update("updateYh", master);
		return b>0?true:false;
	}

	
	public List<Param> selectJsList(Param param) {
		return queryList("selectJsList", param);
	}

	
	public boolean insertJs(Param param) {
		UUID uuid = UUID.randomUUID();
		param.setRoleid(uuid.toString());
		List<Param> l=new ArrayList<Param>();
		String[] s=param.getSource().split(",");
		for (int i=0;i<s.length;i++){
			Param p=new Param();
			p.setRoleid(uuid.toString());
			p.setSourceid(s[i]);
			l.add(p);
		}

		if (insert("insertJs", param) > 0) {
			if(insertBatch("insertRoleSourceBatch", l)>0) return true;
			else return false;
		} else {
			return false;
		}
	}

	
	public boolean deleteJsById(Param param) {
		if (delete("deleteJsById",param) > 0) {
			if(delete("deleteRoleSourceById",param)>0) return true;
			else return false;
		} else {
			return false;
		}
	}

	
	
	public int selectDwListCount(Unit unit) {
		return queryOne("selectDwListCount", unit);
	}

	
	public List<Unit> selectDwList(Unit unit) {
		return queryList("selectDwList", unit);
	}

	
	public List<TreeNode> getBmbmTreeByName(HashMap<String, String> hm) {
		return queryList("getBmbmTreeByName", hm);
	}

	
	public boolean insertDw(Unit unit) {
		int b=insert("insertDw", unit);
		int b2;
		
		return b>0?true:false;
	}

	
	public boolean deleteDwById(Unit unit) {
		int b=delete("deleteDwById", unit);
		return b>0?true:false;
	}

	
	public List<Unit> selectDwById(Unit unit) {
		return queryList("selectDwById", unit);
	}

	
	public boolean updateDw(Unit unit) {
		int b=update("updateDw", unit);
		return b>0?true:false;
	}

	
	public int selectBmbmListCount(Unit unit) {
		return queryOne("selectBmbmListCount", unit);
	}

	
	public List<Unit> selectBmbmList(Unit unit) {
		return queryList("selectBmbmList", unit);
	}

	
	public boolean insertBmbm(Unit unit) {
		int b=insert("insertBmbm", unit);
		return b>0?true:false;
	}

	
	public boolean updateBmbm(Unit unit) {
		int b=update("updateBmbm", unit);
		return b>0?true:false;
	}

	
	public boolean deleteBmbmById(Unit unit) {
		int b=delete("deleteBmbmById", unit);
		return b>0?true:false;
	}

	
	public List<Master> checkname(HashMap hm) {
		return queryList("checkname",hm);
	}

	
	public List<Param> selectTsdqList(Param param) {
		return queryList("selectTsdqList", param);
	}

	
	public int selectXzqhListCount(Unit unit) {
		return queryOne("selectXzqhListCount", unit);
	}

	
	public List<Unit> selectXzqhList(Unit unit) {
		return queryList("selectXzqhList", unit);
	}

	
	public String createGsAnyChartXml(List<Param> l) {
		Map<String,Object> parameter=new HashMap<String,Object>();		
		parameter.put("chart_title", "项目数量统计");//title
		String yName="里程";//y单位
		int precision=0;//小数的位数
		parameter.put("yName", yName);
		parameter.put("precision",precision);
		parameter.put("list",l);
		String chartType = "";
		chartType="pie.ftl";
		return AnyChartUtil.getAnyChartXml(chartType, parameter);
	}

	
	public List<Unit> checkXzqhCfById(Unit unit) {
		return queryList("checkXzqhCfById", unit);
	}

	
	public boolean insertXzqh(Unit unit) {
		int b=insert("insertXzqh", unit);
		return b>0?true:false;
	}

	
	public boolean updateXzqh(Unit unit) {
		int b=update("updateXzqh", unit);
		return b>0?true:false;
	}

	
	public boolean deleteXzqhById(Unit unit) {
		int b=delete("deleteXzqhById", unit);
		return b>0?true:false;
	}

	
	public boolean updateTsdqZt(Param param) {
		int b=update("updateTsdqZt", param);
		return b>0?true:false;
	}

	
	public List<TreeNode> selAllTsdq2(String yhdw) {
		return queryList("selAllTsdq2", yhdw);
	}

	
	public List<TreeNode> selAllTsdq(String yhdw) {
		return queryList("selAllTsdq", yhdw);
	}

	
	public boolean insertTsdq(Param param) {
		String id=UUID.randomUUID().toString();
		param.setId(id);
		List<HashMap<String, String>> nl=new ArrayList<HashMap<String,String>>();
		String[] arr=param.getXzqhdm().split(",");
		String[] arr2=param.getXzqh().split(",");
		for(int i=0;i<arr.length;i++){
			HashMap<String, String> hm=new HashMap<String, String>();
			hm.put("parent", id);
			hm.put("xzqhdm", arr[i]);
			hm.put("xzqh", arr2[i]);
			nl.add(hm);
		}
		if(insert("insertTsdq", param)>0){
			if(insertBatch("insertTsdqList", nl)>0){
				return true;
			}else return false;
		}else return false;
	}

	
	public boolean deleteTsdqById(Param param) {
		if(delete("deleteTsdqById", param)>0){
			if(delete("deleteTsdqList", param)>0){
				return true;
			}else return false;
		}else return false;
		
	}

	
	public Param selectTsdqById(Param param) {
		return queryOne("selectTsdqById", param);
	}

	
	public List<TreeNode> selAllBm(String yhdw) {
		return queryList("selAllBm", yhdw);
	}

	
	public List<TreeNode> selAllBm2(String yhdw) {
		return queryList("selAllBm2", yhdw);
	}

	
	public boolean updateTsdq(Param param) {
		List<HashMap<String, String>> nl=new ArrayList<HashMap<String,String>>();
		String[] arr=param.getXzqhdm().split(",");
		String[] arr2=param.getXzqh().split(",");
		System.out.println(param.getId());
		for(int i=0;i<arr.length;i++){
			HashMap<String, String> hm=new HashMap<String, String>();
			hm.put("parent", param.getId());
			hm.put("xzqhdm", arr[i]);
			hm.put("xzqh", arr2[i]);
			nl.add(hm);
		}
		if(update("updateTsdq", param)>0){
			if(delete("deleteTsdqListById", param)>0){
				if(insertBatch("insertTsdqList", nl)>0){
					return true;
				}else return false;
			}else return false;
		}else return false;
	}

	
	public Master selectYhById(Master master) {
		return queryOne("selectYhById", master);
	}

	
	public List<TreeNode> selAllQx(String yhdw) {
		return queryList("selAllQx", yhdw);
	}

	
	public List<TreeNode> selAllQx2(String yhdw) {
		return queryList("selAllQx2", yhdw);
	}

	
	public Param selectJsById(Param param) {
		return queryOne("selectJsById", param);
	}

	
	public boolean updateJs(Param param) {
		String id=param.getRoleid();
		param.setId(id);
		param.setRoleid("('"+param.getRoleid()+"')");
		List<Param> l=new ArrayList<Param>();
		String[] s=param.getSource().split(",");
		for (int i=0;i<s.length;i++){
			Param p=new Param();
			p.setRoleid(id);
			p.setSourceid(s[i]);
			l.add(p);
		}
		if (update("updateJs", param)>0){
			if(delete("deleteRoleSourceById",param)>=0){
				if(insertBatch("insertRoleSourceBatch", l)>0){
					return true;
				}else return false;
			}else return false;
		}else return false;
		
	}

	
	public List<Param> selQxByUser(Param param) {
		return queryList("selQxByUser", param);
	}

	
	public List<Param> selQxByUser1(Param param) {
		return queryList("selQxByUser1", param);
	}
	
	
	public List<TreeNode> selQxByRoleid(Param param) {
		return queryList("selQxByRoleid", param);
	}

	
	public List<Param> selQxListByRoleid(Param param) {
		return queryList("selQxListByRoleid", param);
	}

	
	public List<Bzbz> selBzbz(Bzbz bzbz) {
		return queryList("selBzbz", bzbz);
	}

	
	public boolean updateBzbz(List<Bzbz> l) {
		int b=updateBatch("updateBzbz", l);
		return b>0?true:false;
	}

	

	public List<Unit> selectLxQlDataList(String id) {
		HashMap<String, String> hm=new HashMap<String, String>();
		
		if(id.length()==7){
			//路线
			String xzqh=id.substring(1);
			String roadcode=id.substring(0,1);
			hm.put("xzqh",xzqh);
			hm.put("roadcode",roadcode);
			return queryList("selectLxDataList", hm);
		}else{
			//桥梁
			hm.put("roadcode",id);
			
			return queryList("selectQlDataList", hm);
		}
	}
	
	public List<Plan_flwbzbz> queryFlwbzbz() {
		return queryList("queryFlwbzbz");
	}

	
	public boolean addFlwbzbz(Plan_flwbzbz flwbzbz) {
		return insert("addFlwbzbz", flwbzbz)>0;
	}

	
	public Plan_flwbzbz queryFlwbzbzById(String id) {
		return queryOne("queryFlwbzbzById", id);
	}

	
	public boolean updateFlwbzbz(Plan_flwbzbz flwbzbz) {
		return update("updateFlwbzbz", flwbzbz)>0;
	}

	
	public boolean dropFlwbzbzById(String id) {
		String [] idArray=id.split(",");
		List<String> list=new ArrayList<String>();
		for(int i=0;i<idArray.length;i++){
			list.add(idArray[i]);
		}
		return deleteBatch("dropFlwbzbzById", list)==list.size();

	}
	
	public List<Yhdzxcs> queryYhdzxcs(Yhdzxcs yhdzxcs){
		return queryList("queryYhdzxcs",yhdzxcs);
	}

	
	public List<TreeNode> loadBmbmList(Unit unit) {
		return queryList("loadBmbmList",unit);
	}

	
	public List<Param> selSqlStrByLxid(Param param) {System.out.println(param.getSourceid());
		if(param.getSourceid().length()==7){//shengji
			System.out.println("sheng");
			if("_____36".equals(param.getSourceid())) param.setSourceid("");
			return queryList("selSqlStrByLxid_sheng", param);
		}else if(param.getSourceid().length()==9){//shi
			System.out.println("shi");
			return queryList("selSqlStrByLxid_shi", param);
		}else{
			System.out.println("xian");
			return queryList("selSqlStrByLxid_xian", param);
		}
	}

	
	public boolean addYhdzxcs(Yhdzxcs yhdzxcs) {
		return insert("addYhdzxcs", yhdzxcs)>0;
	}

	
	public Yhdzxcs queryYhdzxcsById(String id) {
		return queryOne("queryYhdzxcsById", id);
	}

	
	public boolean updateYhdzxcs(Yhdzxcs yhdzxcs) {
		return update("updateYhdzxcs", yhdzxcs)>0;
	}

	
	public List<Yhdzxcs> queryYhdzxcsByLx(Yhdzxcs yhdzxcs) {
		return queryList("queryYhdzxcsByLx",yhdzxcs);
	}

	
	public List<Plan_flwbzbz> queryFlwxmFdfw() {
		return queryList("queryFlwxmFdfw");
	}

	
	public boolean updateFdbzByXmlx(Plan_flwbzbz flwbzbz) {
		return update("updateFdbzByXmlx", flwbzbz)>0;
	}

	
	public List<Param> checkJsCfByName(Param param) {
		return queryList("checkJsCfByName", param);
	}

	
	public List<Param> selJsUsedById(Param param) {
		return queryList("selJsUsedById", param);
	}

	
	public boolean dropYhdzxcsById(String id) {
		String [] idArray=id.split(",");
		List<String> list=new ArrayList<String>();
		for(int i=0;i<idArray.length;i++){
			list.add(idArray[i]);
		}
		return deleteBatch("dropYhdzxcsById", list)==list.size();
	}

	
	public HashMap<String, String> loginCheck(HashMap hm) {
		HashMap lhm=queryOne("loginCheck",hm);
		return lhm;
	}

	
	public List<Master> userlogin(String master) {
		return queryList("userlogin", master);
	}

	
	public List<TreeNode> createMenu(Unit unit) {
		return queryList("createMenu", unit);
	}
}
