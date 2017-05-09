package com.example.bean;


public class HuoDongDetailBean {
	private HuoDongDetailInfo info;

	public HuoDongDetailBean(HuoDongDetailInfo info) {
		this.info = info;
	}

	public HuoDongDetailBean() {
	}

	public HuoDongDetailInfo getInfo() {
		return info;
	}

	public void setInfo(HuoDongDetailInfo info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "HuoDongDetailBean [info=" + info + "]";
	}
	
	
}
