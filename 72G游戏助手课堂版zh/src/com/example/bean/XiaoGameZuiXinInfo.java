package com.example.bean;

public class XiaoGameZuiXinInfo {
	private String id;
	private String name;
	private String icon;
	private String h5src;
	private String game_desc;
	private String click;
	public XiaoGameZuiXinInfo(String id, String name, String icon,
			String h5src, String game_desc, String click) {
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.h5src = h5src;
		this.game_desc = game_desc;
		this.click = click;
	}
	public XiaoGameZuiXinInfo() {
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
	public String getH5src() {
		return h5src;
	}
	public void setH5src(String h5src) {
		this.h5src = h5src;
	}
	public String getGame_desc() {
		return game_desc;
	}
	public void setGame_desc(String game_desc) {
		this.game_desc = game_desc;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	@Override
	public String toString() {
		return "XiaoGameZuiXinInfo [id=" + id + ", name=" + name + ", icon="
				+ icon + ", h5src=" + h5src + ", game_desc=" + game_desc
				+ ", click=" + click + "]";
	}
	

}
