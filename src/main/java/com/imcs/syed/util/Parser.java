package com.imcs.syed.util;

import java.math.BigInteger;

import com.imcs.syed.entity.Order;
import com.imcs.syed.entity.Product;

public class Parser {

	public static com.imcs.syed.product.Product convertToJax(Product product) {
		com.imcs.syed.product.Product jaxProduct = new com.imcs.syed.product.Product();
		jaxProduct.setProductId(BigInteger.valueOf(product.getProductId()));
		jaxProduct.setProductCategory(product.getProductCategory());
		jaxProduct.setProductCount(product.getProductCount());
		jaxProduct.setProductDescription(product.getProductDescription());
		jaxProduct.setProductName(product.getProductName());
		jaxProduct.setProductPrice(product.getProductPrice());
		return jaxProduct;
	}

	public static Product convertToJav(com.imcs.syed.product.Product jaxProduct) {
		Product product = new Product();
		product.setProductId(jaxProduct.getProductId().longValue());
		product.setProductCategory(jaxProduct.getProductCategory());
		product.setProductCount(jaxProduct.getProductCount());
		product.setProductDescription(jaxProduct.getProductDescription());
		product.setProductName(jaxProduct.getProductName());
		product.setProductPrice(jaxProduct.getProductPrice());
		return product;
	}

	public static com.imcs.syed.product.Order convertOrderToJax(Order order) {
		com.imcs.syed.product.Order newOrder = new com.imcs.syed.product.Order();
		newOrder.setCustomerId(BigInteger.valueOf(order.getCustomerId()));
		newOrder.setOrderId(BigInteger.valueOf(order.getOrderId()));
		newOrder.setTotalPrice(order.getTotalPrice());
		newOrder.setPaymentMethodId(BigInteger.valueOf(order.getPaymentMethodId()));
		return newOrder;
	}
}
