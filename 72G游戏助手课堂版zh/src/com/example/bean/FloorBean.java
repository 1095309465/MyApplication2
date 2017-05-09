package com.example.bean;

public class FloorBean {
	private FloorInfo info;

	@Override
	public String toString() {
		return "FloorBean [info=" + info + "]";
	}

	public FloorInfo getInfo() {
		return info;
	}

	public void setInfo(FloorInfo info) {
		this.info = info;
	}

	public FloorBean(FloorInfo info) {
		this.info = info;
	}

	public FloorBean() {
	}
	

}
