package com.example.bean;

import java.util.List;

public class GameDetailTalkBean {
	private List<GameDetailTalkInfo> info;

	public GameDetailTalkBean(List<GameDetailTalkInfo> info) {
		this.info = info;
	}

	public GameDetailTalkBean() {
	}

	@Override
	public String toString() {
		return "GameDetailTalkBean [info=" + info + "]";
	}

	public List<GameDetailTalkInfo> getInfo() {
		return info;
	}

	public void setInfo(List<GameDetailTalkInfo> info) {
		this.info = info;
	}
	
}
