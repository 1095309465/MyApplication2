package com.example.bean;

public class GameDetailInfo {
	private String id;
	private String name;
	private String score;
	private String version;
	private String icon;
	private String snapshot;
	private String size;
	private String dl_back_jifen;
	private String android_dl;
	private String ios_dl;
	private String count_dl;
	private String game_desc;
	public GameDetailInfo(String id, String name, String score,
			String version, String icon, String snapshot, String size,
			String dl_back_jifen, String android_dl, String ios_dl,
			String count_dl, String game_desc) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.version = version;
		this.icon = icon;
		this.snapshot = snapshot;
		this.size = size;
		this.dl_back_jifen = dl_back_jifen;
		this.android_dl = android_dl;
		this.ios_dl = ios_dl;
		this.count_dl = count_dl;
		this.game_desc = game_desc;
	}
	public GameDetailInfo() {
	}
	@Override
	public String toString() {
		return "Game_DetailInfo [id=" + id + ", name=" + name + ", score="
				+ score + ", version=" + version + ", icon=" + icon
				+ ", snapshot=" + snapshot + ", size=" + size
				+ ", dl_back_jifen=" + dl_back_jifen + ", android_dl="
				+ android_dl + ", ios_dl=" + ios_dl + ", count_dl=" + count_dl
				+ ", game_desc=" + game_desc + "]";
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSnapshot() {
		return snapshot;
	}
	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
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
	public String getGame_desc() {
		return game_desc;
	}
	public void setGame_desc(String game_desc) {
		this.game_desc = game_desc;
	}
	

}
