package com.example.bean;

public class GiftDetailBean {
	private GiftDetailInfo info;

	@Override
	public String toString() {
		return "GiftDetailBean [info=" + info + "]";
	}

	public GiftDetailBean(GiftDetailInfo info) {
		this.info = info;
	}

	public GiftDetailBean() {
	}

	public GiftDetailInfo getInfo() {
		return info;
	}

	public void setInfo(GiftDetailInfo info) {
		this.info = info;
	}
	
}
