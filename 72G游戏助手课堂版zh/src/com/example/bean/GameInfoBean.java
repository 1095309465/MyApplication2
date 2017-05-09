package com.example.bean;

import java.util.List;

public class GameInfoBean {
	private List<GameInfo> info;

	public GameInfoBean(List<GameInfo> info) {
		this.info = info;
	}

	public GameInfoBean() {
	}

	@Override
	public String toString() {
		return "GameInfoBean [info=" + info + "]";
	}

	public List<GameInfo> getInfo() {
		return info;
	}

	public void setInfo(List<GameInfo> info) {
		this.info = info;
	}
	

}
