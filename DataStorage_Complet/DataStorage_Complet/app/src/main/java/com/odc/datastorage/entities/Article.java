package com.odc.datastorage.entities;

public class Article {
	private int id;
	private String title;
	private String desc;
	private byte[] logo;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Article(int id, String name, String desc, byte[] logo) {
		super();
		this.id = id;
		this.setTitle(name);
		this.desc = desc;
		this.logo = logo;
	}
	public Article(String name, String desc, byte[] logo) {
		super();
		this.setTitle(name);
		this.desc = desc;
		this.logo = logo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public byte[] getLogo() {
		return logo;
	}


	public void setLogo(byte[] logo) {
		this.logo = logo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	
	
	
}
