package com.example.bean;

public class ZhuanQianInfo {
	
	private String id;
	private String name;
	private String score;
	private String icon;
	private String size;
	private String dl_back_jifen;
	private String h5src;
	private String android_dl;
	private String ios_dl;
	private String count_dl;
	@Override
	public String toString() {
		return "ZhuanQianInfo [id=" + id + ", name=" + name + ", score="
				+ score + ", icon=" + icon + ", size=" + size
				+ ", dl_back_jifen=" + dl_back_jifen + ", h5src=" + h5src
				+ ", android_dl=" + android_dl + ", ios_dl=" + ios_dl
				+ ", count_dl=" + count_dl + "]";
	}
	public ZhuanQianInfo(String id, String name, String score, String icon,
			String size, String dl_back_jifen, String h5src, String android_dl,
			String ios_dl, String count_dl) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.icon = icon;
		this.size = size;
		this.dl_back_jifen = dl_back_jifen;
		this.h5src = h5src;
		this.android_dl = android_dl;
		this.ios_dl = ios_dl;
		this.count_dl = count_dl;
	}
	public ZhuanQianInfo() {
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDl_back_jifen() {
		return dl_back_jifen;
	}
	public void setDl_back_jifen(String dl_back_jifen) {
		this.dl_back_jifen = dl_back_jifen;
	}
	public String getH5src() {
		return h5src;
	}
	public void setH5src(String h5src) {
		this.h5src = h5src;
	}
	public String getAndroid_dl() {
		return android_dl;
	}
	public void setAndroid_dl(String android_dl) {
		this.android_dl = android_dl;
	}
	public String getIos_dl() {
		return ios_dl;
	}
	public void setIos_dl(String ios_dl) {
		this.ios_dl = ios_dl;
	}
	public String getCount_dl() {
		return count_dl;
	}
	public void setCount_dl(String count_dl) {
		this.count_dl = count_dl;
	}
	

}
