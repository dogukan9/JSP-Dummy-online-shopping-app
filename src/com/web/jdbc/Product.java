package com.web.jdbc;

public class Product {
	private int id;
    private String name;
    private int stok;
    private String Image;
    private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(int id, String name, int stok, String image, int price) {
		super();
		this.id = id;
		this.name = name;
		this.stok = stok;
		Image = image;
		this.price = price;
	}
    
	public Product( String name, int stok, String image, int price) {
		super();
		
		this.name = name;
		this.stok = stok;
		Image = image;
		this.price = price;
	}
    
	public Product() {
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", stok=" + stok + ", Image=" + Image + ", price=" + price
				+ "]";
	}
	
    

}
