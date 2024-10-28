package com.pet.entity;

//用户联系
public class Relation {
   
	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public Relation(Integer id, String name, String email, String phone, String note) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.note = note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	private String name;
    
	private String email;
    private String phone;//联系方式
    private String note;//其他要求
	
	public Relation() {
		super();
	}
    
}
