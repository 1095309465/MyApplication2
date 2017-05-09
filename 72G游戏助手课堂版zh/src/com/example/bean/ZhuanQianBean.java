package com.example.bean;

import java.util.List;

public class ZhuanQianBean {
	private List<ZhuanQianInfo> info;

	@Override
	public String toString() {
		return "ZhuanQianBean [info=" + info + "]";
	}

	public ZhuanQianBean(List<ZhuanQianInfo> info) {
		this.info = info;
	}

	public ZhuanQianBean() {
	}

	public List<ZhuanQianInfo> getInfo() {
		return info;
	}

	public void setInfo(List<ZhuanQianInfo> info) {
		this.info = info;
	}
	
	

}
