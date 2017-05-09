package com.example.bean;

import java.util.List;

public class XiaoGameRGameBean {
	private  List<XiaoGameRGameInfo> info;

	public XiaoGameRGameBean(List<XiaoGameRGameInfo> info) {
		this.info = info;
	}

	public XiaoGameRGameBean() {
	}

	@Override
	public String toString() {
		return "XiaoGameRGameBean [info=" + info + "]";
	}

	public List<XiaoGameRGameInfo> getInfo() {
		return info;
	}

	public void setInfo(List<XiaoGameRGameInfo> info) {
		this.info = info;
	}
	

}
