package com.pet.entity;

import java.util.Date;

//用户
public class User {
   
	

	private Integer id;    
   
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public User(Integer id, String username, String pwd, String sex, String nickname, Date registeTime) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.sex = sex;
		this.nickname = nickname;
		this.registeTime = registeTime;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegisteTime() {
		return registeTime;
	}
	public void setRegisteTime(Date registeTime) {
		this.registeTime = registeTime;
	}
	private String username;
    
	private String pwd;
    private String sex;//联系方式
    private String nickname;//其他要求
	private Date registeTime;
	public User() {
		super();
	}
    
}
