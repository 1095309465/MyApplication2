package com.example.bean;

import java.util.List;

public class XiaoGameZuiXinBean {
	
	private List<XiaoGameZuiXinInfo> info;

	@Override
	public String toString() {
		return "XiaoGameZuiXinBean [info=" + info + "]";
	}

	public XiaoGameZuiXinBean(List<XiaoGameZuiXinInfo> info) {
		this.info = info;
	}

	public XiaoGameZuiXinBean() {
	}

	public List<XiaoGameZuiXinInfo> getInfo() {
		return info;
	}

	public void setInfo(List<XiaoGameZuiXinInfo> info) {
		this.info = info;
	}
	
	

}
