package com.example.bean;

import java.util.List;

public class HuoDongBean {
	private List<HuoDongInfo> info;

	public HuoDongBean(List<HuoDongInfo> info) {
		this.info = info;
	}

	public HuoDongBean() {
	}

	@Override
	public String toString() {
		return "HuoDongBean [info=" + info + "]";
	}

	public List<HuoDongInfo> getInfo() {
		return info;
	}

	public void setInfo(List<HuoDongInfo> info) {
		this.info = info;
	}
	

}
