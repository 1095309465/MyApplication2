package com.example.bean;

public class GiftDetailInfo {
	private String id;
	private String name;
	private String gamename;
	private String icon;
	private String total;
	private String remain;
	private String stime;
	private String etime;
	private String consume;
	private String platform;
	private String content;
	private String howget;
	private String game_id;
	private String game_type;
	private String size;
	private String android_dl;
	private String ios_dl;
	public GiftDetailInfo(String id, String name, String gamename, String icon,
			String total, String remain, String stime, String etime,
			String consume, String platform, String content, String howget,
			String game_id, String game_type, String size, String android_dl,
			String ios_dl) {
		this.id = id;
		this.name = name;
		this.gamename = gamename;
		this.icon = icon;
		this.total = total;
		this.remain = remain;
		this.stime = stime;
		this.etime = etime;
		this.consume = consume;
		this.platform = platform;
		this.content = content;
		this.howget = howget;
		this.game_id = game_id;
		this.game_type = game_type;
		this.size = size;
		this.android_dl = android_dl;
		this.ios_dl = ios_dl;
	}
	public GiftDetailInfo() {
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getConsume() {
		return consume;
	}
	public void setConsume(String consume) {
		this.consume = consume;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHowget() {
		return howget;
	}
	public void setHowget(String howget) {
		this.howget = howget;
	}
	public String getGame_id() {
		return game_id;
	}
	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}
	public String getGame_type() {
		return game_type;
	}
	public void setGame_type(String game_type) {
		this.game_type = game_type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	@Override
	public String toString() {
		return "GiftDetailInfo [id=" + id + ", name=" + name + ", gamename="
				+ gamename + ", icon=" + icon + ", total=" + total
				+ ", remain=" + remain + ", stime=" + stime + ", etime="
				+ etime + ", consume=" + consume + ", platform=" + platform
				+ ", content=" + content + ", howget=" + howget + ", game_id="
				+ game_id + ", game_type=" + game_type + ", size=" + size
				+ ", android_dl=" + android_dl + ", ios_dl=" + ios_dl + "]";
	}
	

}
