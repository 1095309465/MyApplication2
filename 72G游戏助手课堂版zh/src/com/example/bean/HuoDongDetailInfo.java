package com.example.bean;

public class HuoDongDetailInfo {
	private String id;
	private String aname;
	private String shortname;
	private String hotpic;
	private String expimg;
	private String astime;
	private String aetime;
	private String content;
	private String isimg;
	private String writer;
	private String pubdate;
	private String comment_total;
	private String status;
	@Override
	public String toString() {
		return "huoDongDetailInfo [id=" + id + ", aname=" + aname
				+ ", shortname=" + shortname + ", hotpic=" + hotpic
				+ ", expimg=" + expimg + ", astime=" + astime + ", aetime="
				+ aetime + ", content=" + content + ", isimg=" + isimg
				+ ", writer=" + writer + ", pubdate=" + pubdate
				+ ", comment_total=" + comment_total + ", status=" + status
				+ "]";
	}
	public HuoDongDetailInfo(String id, String aname, String shortname,
			String hotpic, String expimg, String astime, String aetime,
			String content, String isimg, String writer, String pubdate,
			String comment_total, String status) {
		this.id = id;
		this.aname = aname;
		this.shortname = shortname;
		this.hotpic = hotpic;
		this.expimg = expimg;
		this.astime = astime;
		this.aetime = aetime;
		this.content = content;
		this.isimg = isimg;
		this.writer = writer;
		this.pubdate = pubdate;
		this.comment_total = comment_total;
		this.status = status;
	}
	public HuoDongDetailInfo() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getHotpic() {
		return hotpic;
	}
	public void setHotpic(String hotpic) {
		this.hotpic = hotpic;
	}
	public String getExpimg() {
		return expimg;
	}
	public void setExpimg(String expimg) {
		this.expimg = expimg;
	}
	public String getAstime() {
		return astime;
	}
	public void setAstime(String astime) {
		this.astime = astime;
	}
	public String getAetime() {
		return aetime;
	}
	public void setAetime(String aetime) {
		this.aetime = aetime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsimg() {
		return isimg;
	}
	public void setIsimg(String isimg) {
		this.isimg = isimg;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getComment_total() {
		return comment_total;
	}
	public void setComment_total(String comment_total) {
		this.comment_total = comment_total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
