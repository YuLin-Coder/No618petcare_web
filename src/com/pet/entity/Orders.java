package com.pet.entity;

import java.util.Date;

//分类
public class Orders {
   
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	private int id;    
   
	private int product_id;
    
	private int uid;
	private int total_price;
	private int quantity;//数量
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private Date create_time;
	public String getOrders_no() {
		return orders_no;
	}
	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}
	private String orders_no;
   public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public Orders() {
		super();
	}
	public void setProduct(Product product) {
		this.product = product;
	}
private User user;
   private Product product;
	
}
