package com.cart.model;

public class cartModel {
	private String username;
	private int productid;
	private String productname;
	private Double productprice;
	private int productquantity;
	public cartModel(String username, int productid, String productname, Double productprice, int productquantity) {
		super();
		this.username = username;
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.productquantity = productquantity;
	}
	public cartModel() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Double getProductprice() {
		return productprice;
	}
	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}
	public int getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}
	@Override
	public String toString() {
		return "cartModel [username=" + username + ", productid=" + productid + ", productname=" + productname
				+ ", productprice=" + productprice + ", productquantity=" + productquantity + "]";
	}
	
}
