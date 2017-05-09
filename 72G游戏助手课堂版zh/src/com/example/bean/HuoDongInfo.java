package com.example.bean;

public class HuoDongInfo {
	
	private String id;
	private String aname;
	private String shortname;
	private String hotpic;
	private String astime;
	private String aetime;
	private String total_join_user;
	private String status;
	@Override
	public String toString() {
		return "HuoDongInfo [id=" + id + ", aname=" + aname + ", shortname="
				+ shortname + ", hotpic=" + hotpic + ", astime=" + astime
				+ ", aetime=" + aetime + ", total_join_user=" + total_join_user
				+ ", status=" + status + "]";
	}
	public HuoDongInfo(String id, String aname, String shortname,
			String hotpic, String astime, String aetime,
			String total_join_user, String status) {
		this.id = id;
		this.aname = aname;
		this.shortname = shortname;
		this.hotpic = hotpic;
		this.astime = astime;
		this.aetime = aetime;
		this.total_join_user = total_join_user;
		this.status = status;
	}
	public HuoDongInfo() {
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
	public String getTotal_join_user() {
		return total_join_user;
	}
	public void setTotal_join_user(String total_join_user) {
		this.total_join_user = total_join_user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
