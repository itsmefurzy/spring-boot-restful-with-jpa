package com.eintrusty.dao;

import java.util.List;

import com.eintrusty.entity.Product;

public interface ProductDao {
	
	List<Product> getAllProduct();
	Product getProductById(int productId);
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	List<Product> getAllProductNative();
}
