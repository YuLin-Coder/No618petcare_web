package com.pet.entity;

import java.util.Date;

//萌宠资讯
public class News {
   
	public Integer getId() {
		return id;
	}

	

	private Integer id;      
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public News(Integer id, String title, String content, String photo, Date fbsj, String editor) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.fbsj = fbsj;
		this.editor = editor;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getFbsj() {
		return fbsj;
	}

	public void setFbsj(Date fbsj) {
		this.fbsj = fbsj;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	private String title;    
	private String content;
    private String photo;//封面图片
    private Date fbsj;//发布时间
    private String editor;
	
	public News() {
		super();
	}
    
}
