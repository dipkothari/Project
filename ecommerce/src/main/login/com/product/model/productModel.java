package com.product.model;

public class productModel {
	private int productid;
	private String productname;
	private Double productprice;
	private int productquantity;
	
	
	public productModel(int productid, String productname, Double productprice,int productquantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.productquantity=productquantity;
	}
	public productModel() {
	
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
		return "productModel [productid=" + productid + ", productname=" + productname + ", productprice="
				+ productprice + ", productquantity=" + productquantity + "]";
	}

	
	
}
