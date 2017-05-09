package com.example.bean;

public class ShouYouInfo {
	/*
	{
	info: [
	{},
	{},
	{},
	{},
	{},
	{},
	{},
	{},
	{},
	{
	id: "4475",
	name: "《巴啦啦小魔仙魔箭小公主》欢度国庆礼包",
	gamename: "巴啦啦小魔仙魔箭小公主",
	icon: "http://i3.72g.com/upload/201509/201509301625241395.png",
	remain: 24,
	gifttype: "1",
	consume: "0.0",
	content: "金币*2000；炸弹*2；体力*4 "
	}
	],
	page: {
	total: 477,
	pagesize: 10,
	page: 1,
	page_total: 48
	},
	state: "success"
	}
	*/
	private String id;
	private String name;
	private String gamename;
	private String icon;
	private int remain;
	private String gifttype;
	private String consume;
	private String content;
	@Override
	public String toString() {
		return "ShouYouInfo [id=" + id + ", name=" + name + ", gamename="
				+ gamename + ", icon=" + icon + ", remain=" + remain
				+ ", gifttype=" + gifttype + ", consume=" + consume
				+ ", content=" + content + "]";
	}
	public ShouYouInfo(String id, String name, String gamename, String icon,
			int remain, String gifttype, String consume, String content) {
		this.id = id;
		this.name = name;
		this.gamename = gamename;
		this.icon = icon;
		this.remain = remain;
		this.gifttype = gifttype;
		this.consume = consume;
		this.content = content;
	}
	public ShouYouInfo() {
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
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public String getGifttype() {
		return gifttype;
	}
	public void setGifttype(String gifttype) {
		this.gifttype = gifttype;
	}
	public String getConsume() {
		return consume;
	}
	public void setConsume(String consume) {
		this.consume = consume;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
