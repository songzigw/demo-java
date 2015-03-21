package com.song.demo.api;

/**
 * 单品信息
 * @author 张松
 *
 */
public class ItemBean extends Result {

	private static final long serialVersionUID = -9019537719111520272L;

	private String title;
	
	private String picUrl;

	private String price;
	
	private String detailUrl;
	
	private String numIid;
	
	public String getNumIid() {
		return numIid;
	}

	public void setNumIid(String numIid) {
		this.numIid = numIid;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
