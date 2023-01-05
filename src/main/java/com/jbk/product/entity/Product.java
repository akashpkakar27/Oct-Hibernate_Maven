package com.jbk.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Product {

	@Id

	private int productId;

	@Column(unique = true, nullable = false)
	private String productName;

	@Column(nullable = false)
	private double productPrice;
	
	private String productMfg;
	
	@Column(nullable = false)
	private String productCategory;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, double productPrice, String productMfg, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productMfg = productMfg;
		this.productCategory = productCategory;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductMfg() {
		return productMfg;
	}

	public void setProductMfg(String productMfg) {
		this.productMfg = productMfg;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productMfg=" + productMfg + ", productCategory=" + productCategory + "]";
	}

}
