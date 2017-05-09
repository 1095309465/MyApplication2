package com.example.bean;

import java.util.List;

public class XiaoGameVPBean {
	private List<XiaoGameVPInfo> info;

	@Override
	public String toString() {
		return "XiaoGameVPBean [info=" + info + "]";
	}

	public XiaoGameVPBean(List<XiaoGameVPInfo> info) {
		this.info = info;
	}

	public XiaoGameVPBean() {
	}

	public List<XiaoGameVPInfo> getInfo() {
		return info;
	}

	public void setInfo(List<XiaoGameVPInfo> info) {
		this.info = info;
	}
	

}
