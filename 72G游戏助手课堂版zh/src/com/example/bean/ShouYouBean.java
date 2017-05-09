package com.example.bean;

import java.util.List;
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

public class ShouYouBean {
	//变量的名字不能写错，因为
	private List<ShouYouInfo> info;
	private ShouYouPage  page;
	private String state;
	@Override
	public String toString() {
		return "ShouYouBean [info=" + info + ", page=" + page + ", state="
				+ state + "]";
	}
	public List<ShouYouInfo> getInfo() {
		return info;
	}
	public void setInfo(List<ShouYouInfo> info) {
		this.info = info;
	}
	public ShouYouPage getPage() {
		return page;
	}
	public void setPage(ShouYouPage page) {
		this.page = page;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ShouYouBean(List<ShouYouInfo> info, ShouYouPage page, String state) {
		this.info = info;
		this.page = page;
		this.state = state;
	}
	public ShouYouBean() {
	}
	
	
	

}
