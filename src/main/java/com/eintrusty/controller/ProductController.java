package com.eintrusty.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.eintrusty.entity.Product;
import com.eintrusty.service.ProductService;

@Controller
@RequestMapping("web")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	@SuppressWarnings("unchecked")
	@GetMapping("products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> listProduct = productService.getAllProduct();
		return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
	}
	@PutMapping("product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	@DeleteMapping("product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	//coba query native
	@SuppressWarnings("unchecked")
	@GetMapping("productsnative")
	public ResponseEntity<List<Product>> getAllProductNative() {
		List<Product> listProduct = productService.getAllProductNative();
		return new ResponseEntity<List<Product>>(listProduct,HttpStatus.OK);
	}
	
 
}
