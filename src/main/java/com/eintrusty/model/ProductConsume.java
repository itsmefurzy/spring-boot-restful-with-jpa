package com.eintrusty.model;

import java.util.function.Function;

public class ProductConsume {
	private int productId;
	private String productName;
	private int categoryId;
	private int supplierId;
	private String quantity;
	private String unitPrice;
	
	public ProductConsume() {
		
		// TODO Auto-generated constructor stub
	}

	public ProductConsume(int productId, String productName, int categoryId, int supplierId, String quantity,
			String unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.supplierId = supplierId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Produt ID : ").append(getProductId()).append(",");
		sb.append("Product Name : ").append(getProductName()).append(",");
		return sb.toString();
	}
	public String showCustom(Function<ProductConsume,String> fun) {
		return fun.apply(this);
	}

}
