package com.example.bean;

import java.util.List;

public class HuoDongDetailTalkBean {
	private List<HuoDongDetailTalkInfo> info;

	public HuoDongDetailTalkBean(List<HuoDongDetailTalkInfo> info) {
		this.info = info;
	}

	public HuoDongDetailTalkBean() {
	}

	@Override
	public String toString() {
		return "HuoDongDetailTalkBean [info=" + info + "]";
	}

	public List<HuoDongDetailTalkInfo> getInfo() {
		return info;
	}

	public void setInfo(List<HuoDongDetailTalkInfo> info) {
		this.info = info;
	}
	

}
