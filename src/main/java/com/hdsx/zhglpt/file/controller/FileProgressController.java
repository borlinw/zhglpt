package com.hdsx.zhglpt.file.controller;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdsx.zhglpt.file.bean.State;
import com.hdsx.zhglpt.utile.ResponseUtils;
import com.hdsx.webutil.struts.BaseActionSupport;

public class FileProgressController extends BaseActionSupport{
	private State state;
		
    public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}



    public String progressBar() {
    	// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		this.state=(State)session.getAttribute("state");		
		if(state==null)
		{
			System.out.println("action is null");
			state=new State();
			state.setCurrentItem(0);
			ResponseUtils.write(getresponse(), "0");
		}
		else{
			
			Double a=Double.parseDouble(state.getReadedBytes()+"");
			Double b=Double.parseDouble(state.getTotalBytes()+"");			
			double result=a/b*100;
			state.setRate((int)result);
			System.out.println(result+"--------");
			ResponseUtils.write(getresponse(), result+"");
			}
		return null;
    }
}
