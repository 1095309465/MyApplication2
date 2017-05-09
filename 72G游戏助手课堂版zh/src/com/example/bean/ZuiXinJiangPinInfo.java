package com.example.bean;

public class ZuiXinJiangPinInfo {
	private String name;
	private String id;
	private String prize_type;
	private String consume;
	private String icon;
	private String remain;
	@Override
	public String toString() {
		return "ZuiXinJiangPinInfo [name=" + name + ", id=" + id
				+ ", prize_type=" + prize_type + ", consum=" + consume
				+ ", icon=" + icon + ", remain=" + remain + "]";
	}
	public ZuiXinJiangPinInfo(String name, String id, String prize_type,
			String consume, String icon, String remain) {
		this.name = name;
		this.id = id;
		this.prize_type = prize_type;
		this.consume = consume;
		this.icon = icon;
		this.remain = remain;
	}
	public ZuiXinJiangPinInfo() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrize_type() {
		return prize_type;
	}
	public void setPrize_type(String prize_type) {
		this.prize_type = prize_type;
	}
	public String getConsume() {
		return consume;
	}
	public void setConsume(String consume) {
		this.consume = consume;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	

}
