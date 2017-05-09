package com.example.bean;

public class XiaoGameVPInfo {
	private String name;
	private String link;
	private String image;

	public XiaoGameVPInfo(String name, String link, String image) {
		this.name = name;
		this.link = link;
		this.image = image;
	}

	public XiaoGameVPInfo() {
	}

	@Override
	public String toString() {
		return "XiaoGameVPInfo [name=" + name + ", link=" + link + ", image="
				+ image + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
