package com.hdsx.zhglpt.xtgl.server.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hdsx.dao.query.base.BaseOperate;
import com.hdsx.zhglpt.xtgl.bean.Dzdt;
import com.hdsx.zhglpt.xtgl.bean.Param;
import com.hdsx.zhglpt.xtgl.bean.ProgBean;
import com.hdsx.zhglpt.xtgl.server.DzdtServer;
@Service
public class DzdtServerImpl extends BaseOperate  implements DzdtServer{
	public DzdtServerImpl() {
		super("xtgl", "jdbc");
	}

	
	public List<Dzdt> selLines(Dzdt dzdt) {
		return queryList("selLines",dzdt);
	}

	
	public List<Param> xmlxCountTj(Param param) {
		return queryList("xmlxCountTj", param);
	}

	
	public List<ProgBean> selectExistLxProgramList(ProgBean param) {
		return queryList("selectExistLxProgramList", param);
	}

	
	public List<Param> selectExistQlProgramList(Param param) {
		return queryList("selectExistQlProgramList", param);
	}

	
	public int selectExistLxProgramListCount(Param param) {
		return queryOne("selectExistLxProgramListCount", param);
	}

	
	public int selectExistQlProgramListCount(Param param) {
		return queryOne("selectExistQlProgramListCount", param);
	}
	
}
