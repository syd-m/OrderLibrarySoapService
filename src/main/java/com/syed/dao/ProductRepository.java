package com.syed.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.syed.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByProductName(String productName);

	List<Product> findByProductNameAndProductCategory(String productName, String productCategory);
}
