package com.example.bean;

public class WoDeInfo {
	
	private String id;
	private String bname;
	private String target;
	private String target_id;
	private String bimg;
	private String px;
	public WoDeInfo(String id, String bname, String target, String target_id,
			String bimg, String px) {
		this.id = id;
		this.bname = bname;
		this.target = target;
		this.target_id = target_id;
		this.bimg = bimg;
		this.px = px;
	}
	public WoDeInfo() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getTarget_id() {
		return target_id;
	}
	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public String getPx() {
		return px;
	}
	public void setPx(String px) {
		this.px = px;
	}
	@Override
	public String toString() {
		return "WoDeInfo [id=" + id + ", bname=" + bname + ", target=" + target
				+ ", target_id=" + target_id + ", bimg=" + bimg + ", px=" + px
				+ "]";
	}
	

}
