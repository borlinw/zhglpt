package com.hdsx.zhglpt.xtgl.server;

import java.util.List;

import com.hdsx.zhglpt.xtgl.bean.Dzdt;
import com.hdsx.zhglpt.xtgl.bean.Param;
import com.hdsx.zhglpt.xtgl.bean.ProgBean;

public interface DzdtServer {

	List<Dzdt> selLines(Dzdt dzdt);

	List<Param> xmlxCountTj(Param param);

	List<ProgBean> selectExistLxProgramList(ProgBean param);

	List<Param> selectExistQlProgramList(Param param);

	int selectExistLxProgramListCount(Param param);

	int selectExistQlProgramListCount(Param param);
	
}
