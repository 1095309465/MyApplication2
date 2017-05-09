package com.example.bean;

public class FloorInfo {
	private String id;
	private String uid;
	private String content;
	private String img;
	private String litpic;
	private String pubdate;
	private String floor;
	private String nickname;
	private String hpic;
	public FloorInfo(String id, String uid, String content,
			String img, String litpic, String pubdate, String floor,
			String nickname, String hpic) {
		this.id = id;
		this.uid = uid;
		this.content = content;
		this.img = img;
		this.litpic = litpic;
		this.pubdate = pubdate;
		this.floor = floor;
		this.nickname = nickname;
		this.hpic = hpic;
	}
	public FloorInfo() {
	}
	
	@Override
	public String toString() {
		return "HuoDongDetailTalkInfo [id=" + id + ", uid=" + uid
				+ ", content=" + content + ", img=" + img + ", litpic="
				+ litpic + ", pubdate=" + pubdate + ", floor=" + floor
				+ ", nickname=" + nickname + ", hpic=" + hpic + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLitpic() {
		return litpic;
	}
	public void setLitpic(String litpic) {
		this.litpic = litpic;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHpic() {
		return hpic;
	}
	public void setHpic(String hpic) {
		this.hpic = hpic;
	}

}
