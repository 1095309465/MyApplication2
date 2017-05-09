package com.example.bean;

import java.util.List;

public class CaiNiXiHuanBean {
	private List<CaiNiXiHuanInfo> info;

	public CaiNiXiHuanBean(List<CaiNiXiHuanInfo> info) {
		this.info = info;
	}
	

	public CaiNiXiHuanBean() {
	}


	@Override
	public String toString() {
		return "CaiNiXiHuanBean [info=" + info + "]";
	}

	public List<CaiNiXiHuanInfo> getInfo() {
		return info;
	}

	public void setInfo(List<CaiNiXiHuanInfo> info) {
		this.info = info;
	}
	

}
