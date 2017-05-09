package com.example.bean;

public class ShouYouPage {
	/**
	 * page: {
	total: 477,
	pagesize: 10,
	page: 1,
	page_total: 48
	},
	 */
	private int total;
	private int pagesize;
	private int page;
	private int page_total;
	@Override
	public String toString() {
		return "ShouYouPage [total=" + total + ", pagesize=" + pagesize
				+ ", page=" + page + ", page_total=" + page_total + "]";
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPage_total() {
		return page_total;
	}
	public void setPage_total(int page_total) {
		this.page_total = page_total;
	}
	public ShouYouPage(int total, int pagesize, int page, int page_total) {
		this.total = total;
		this.pagesize = pagesize;
		this.page = page;
		this.page_total = page_total;
	}
	public ShouYouPage() {
	}
	
}
