package com.eintrusty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eintrusty.dao.ProductDao;
import com.eintrusty.entity.Product;
import com.eintrusty.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Product prod = productDao.getProductById(productId);
		return prod;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(productId);
		
	}
	//ujicoba native
	@Override
   public List<Product> getAllProductNative(){
	   return productDao.getAllProductNative();
   }
}
