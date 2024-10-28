package com.pet.entity;

//宠物用品
public class Product {
   
	public Integer getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Product(Integer id, String name, Integer stock, int price, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.photo = photo;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	private Integer id;    
   
	private String name;
	private Integer stock;//库存
    
	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
	}



	private int price;
    private String photo;
	
	public Product() {
		super();
	}
    
}
