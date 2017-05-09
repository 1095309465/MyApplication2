package com.example.bean;

public class XiaoGameRGameInfo {
	private String id;
	private String icon;
	private String h5src;
	private String name;
	@Override
	public String toString() {
		return "XiaoGameRGameInfo [id=" + id + ", icon=" + icon + ", h5src="
				+ h5src + ", name=" + name + "]";
	}
	public XiaoGameRGameInfo(String id, String icon, String h5src, String name) {
		this.id = id;
		this.icon = icon;
		this.h5src = h5src;
		this.name = name;
	}
	public XiaoGameRGameInfo() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getH5src() {
		return h5src;
	}
	public void setH5src(String h5src) {
		this.h5src = h5src;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
