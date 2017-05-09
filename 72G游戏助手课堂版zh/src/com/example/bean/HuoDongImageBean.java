package com.example.bean;

import java.util.List;

public class HuoDongImageBean {
	private List<HuoDongImageInfo> info;

	public HuoDongImageBean(List<HuoDongImageInfo> info) {
		this.info = info;
	}

	public HuoDongImageBean() {
	}

	@Override
	public String toString() {
		return "HuoDongImageBean [info=" + info + "]";
	}

	public List<HuoDongImageInfo> getInfo() {
		return info;
	}

	public void setInfo(List<HuoDongImageInfo> info) {
		this.info = info;
	}
	

}
