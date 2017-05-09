package com.example.bean;

import java.util.List;

public class WoDeBean {
	
	private List<WoDeInfo> info;

	public WoDeBean(List<WoDeInfo> info) {
		this.info = info;
	}

	public WoDeBean() {
	}

	public List<WoDeInfo> getInfo() {
		return info;
	}

	public void setInfo(List<WoDeInfo> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "WoDeBean [info=" + info + "]";
	}
	


}
