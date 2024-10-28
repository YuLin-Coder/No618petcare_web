package com.pet.entity;

//分类类别
public class Category {
   
	
	private Integer id;    
   
	private String cname;
    
	private String note;
   
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public Category(Integer id, String cname, String note) {
		super();
		this.id = id;
		this.cname = cname;
		this.note = note;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Category() {
		super();
	}
    
}
