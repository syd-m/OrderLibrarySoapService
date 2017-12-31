package com.syed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syed.dao.OrderRepository;
import com.syed.dao.ProductRepository;
import com.syed.entity.Order;
import com.syed.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		return productRepo.findByProductName(productName);
	}

	@Override
	public List<Product> getProductsByNameAndCategory(String productName, String productCategory) {
		return productRepo.findByProductNameAndProductCategory(productName, productCategory);
	}

	@Override
	public Order createOrder(Order newOrder) {
		return orderRepo.save(newOrder);
	}
}
