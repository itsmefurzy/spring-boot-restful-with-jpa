package com.eintrusty.client;

import java.net.URI;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import com.eintrusty.entity.Product;
import com.eintrusty.model.*;

public class RestClientUtil {

	public void getProductByIdDemo(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/web/product/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Product.class, id);
		Product product = responseEntity.getBody();
		System.out.println("ProdutId : " + product.getProductId() + ", Product Name : " + product.getProductName()
				+ ", SupplierId : " + product.getSuplierId() + ", Quantity : " + product.getQuantity()
				+ ", categoryId : " + product.getCategoryId() + ", QuantityPerUnit : " + product.getQuantity() + ""
				+ ", UnitPrice : " + product.getUnitPrice());
	}

	public void getAllProductDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/web/products";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<ProductConsume[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				ProductConsume[].class);
		// Product product = responseEntity.getBody();
		ProductConsume[] arrayProduct = responseEntity.getBody();
		  Map <String,String> listProduct = new HashMap<String, String>();
		if(arrayProduct.length !=0 ) {
		for (ProductConsume product : arrayProduct) {
			System.out.println("ProdutId : " + product.getProductId() + ", Product Name : " + product.getProductName()
					+ ", SupplierId : " + product.getSupplierId() + ", Quantity : " + product.getQuantity()
					+ ", categoryId : " + product.getCategoryId() + ", QuantityPerUnit : " + product.getQuantity() + ""
					+ ", UnitPrice : " + product.getUnitPrice());

		      
		        listProduct.put(Integer.toString(product.getProductId()), product.getProductName());
		       
		}
		}else {
			System.out.println("Tidak ada Product yang tersedia");
			
		}
		//Consumer <ProductConsume> con = (ProductConsume pc) -> System.out.println(pc.getProductId());
		//Map<String,String> result = listProduct.entrySet().stream()
				///.collect(Collectors.toMap(p->p.,p->p.getValue()));
		//if(listProduct !=null ) {
			//System.out.println(result);
		//}
        
	}
	public void updateProductDemo() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url ="http://localhost:8080/web/product";
        Product prod = new Product();
        prod.setProductId(1);
        prod.setProductName("JNE");
        prod.setSuplierId(1);
        prod.setCategoryId(1);
        prod.setQuantity("10");
        prod.setUnitPrice("1000");
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(prod,headers);
        restTemplate.put(url, requestEntity);
	}
	public void deleteProductDemo() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/web/product/{id}";
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
	}
	 public static void main(String args[]) {
	    	RestClientUtil util = new RestClientUtil();
	        //util.getArticleByIdDemo();
	    	util.getAllProductDemo();;
	    	//util.addArticleDemo();
	    	//util.updateArticleDemo();
	    	//util.deleteArticleDemo();
	    	//util.getProductByIdDemo(3);
	    }    

}
