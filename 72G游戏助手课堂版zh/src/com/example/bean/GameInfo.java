package com.example.bean;

public class GameInfo {

	private String id;
	private String name;
	private String icon;
	private String count_dl;

	public GameInfo(String id, String name, String icon, String count_dl) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.count_dl = count_dl;
	}

	public GameInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCount_dl() {
		return count_dl;
	}

	public void setCount_dl(String count_dl) {
		this.count_dl = count_dl;
	}

	@Override
	public String toString() {
		return "GameInfo [id=" + id + ", name=" + name + ", icon=" + icon
				+ ", count_dl=" + count_dl + "]";
	}

}
