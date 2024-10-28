package com.pet.entity;

import java.util.Date;

//宠物
public class Pet {
	private Integer id;       
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getFbrq() {
		return fbrq;
	}

	public void setFbrq(Date fbrq) {
		this.fbrq = fbrq;
	}

	public Pet(Integer id, String name, int c_id, String photo, String characters, String detail,
			Date fbrq) {
		super();
		this.id = id;
		this.name = name;
		this.c_id = c_id;
	
		this.photo = photo;
		this.characters = characters;
		this.detail = detail;
		this.fbrq = fbrq;
	}

	private String name;   
	private int c_id; 
	private Category category;
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private String photo;
    private String characters;
    private String detail;//宠物介绍
  

	private Date fbrq;//发布日期
	
	public Pet() {
		super();
	}
    
}
