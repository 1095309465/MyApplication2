package com.example.bean;

import java.util.List;

public class ZuiXinJiangPinBean {
	private List<ZuiXinJiangPinInfo> info;

	public ZuiXinJiangPinBean(List<ZuiXinJiangPinInfo> info) {
		this.info = info;
	}

	public ZuiXinJiangPinBean() {
	}

	public List<ZuiXinJiangPinInfo> getInfo() {
		return info;
	}

	public void setInfo(List<ZuiXinJiangPinInfo> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ZuiXinJiangPinBean [info=" + info + "]";
	} 
	
}
