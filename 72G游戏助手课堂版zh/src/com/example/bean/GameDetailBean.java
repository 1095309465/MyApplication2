package com.example.bean;


public class GameDetailBean {
	private GameDetailInfo info;

	@Override
	public String toString() {
		return "GameDetailBean [info=" + info + "]";
	}

	public GameDetailBean(GameDetailInfo info) {
		this.info = info;
	}

	public GameDetailBean() {
	}

	public GameDetailInfo getInfo() {
		return info;
	}

	public void setInfo(GameDetailInfo info) {
		this.info = info;
	}

	

}
