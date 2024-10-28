package com.pet.entity;

import java.util.Date;

//留言信息
public class Messages {
   
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Messages(Integer id, String content, int uid, Date create_time) {
		super();
		this.id = id;
		this.content = content;
		this.uid = uid;
		this.create_time = create_time;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	private Integer id;    
    private String content;//留言内容
    private int uid;//外键
    private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private Date create_time;
	public Messages() {
		super();
	}
    
}
