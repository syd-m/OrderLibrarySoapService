package com.imcs.syed.service;

import java.util.List;

import com.imcs.syed.entity.Order;
import com.imcs.syed.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();

	List<Product> getProductsByName(String productName);

	List<Product> getProductsByNameAndCategory(String productName, String productCategory);
	
	Order createOrder(Order newOrder);
}
