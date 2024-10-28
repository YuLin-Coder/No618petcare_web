package com.pet.entity;

//轮播图
public class Banner {
   

	

	private Integer id;    
   
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUrl() {
		return url;
	}

	public Banner(Integer id, String photo, String url,String note) {
		super();
		this.id = id;
		this.photo = photo;
	
		this.url = url;
		this.note = note;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String photo;
    
	private String note;
    private String url;
	
	public Banner() {
		super();
	}
    
}
