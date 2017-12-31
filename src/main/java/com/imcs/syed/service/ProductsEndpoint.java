package com.imcs.syed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.imcs.syed.entity.Order;
import com.imcs.syed.entity.Product;
import com.imcs.syed.product.CreateOrderRequest;
import com.imcs.syed.product.CreateOrderResponse;
import com.imcs.syed.product.GetAllProductsRequest;
import com.imcs.syed.product.GetAllProductsResponse;
import com.imcs.syed.product.GetProductsByNameAndCategoryRequest;
import com.imcs.syed.product.GetProductsByNameAndCategoryResponse;
import com.imcs.syed.product.GetProductsByNameRequest;
import com.imcs.syed.product.GetProductsByNameResponse;
import com.imcs.syed.util.Parser;

@Endpoint
public class ProductsEndpoint {

	private static final String NAMESPACE_URI = "http://syed.imcs.com/Product";

	@Autowired
	ProductService productService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
	@ResponsePayload
	public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
		GetAllProductsResponse response = new GetAllProductsResponse();
		List<Product> allProducts = productService.getAllProducts();
		List<com.imcs.syed.product.Product> allProductsJax = new ArrayList<>();
		for (Product product : allProducts) {
			allProductsJax.add(Parser.convertToJax(product));
			response.getAllProducts().addAll(allProductsJax);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsByNameRequest")
	@ResponsePayload
	public GetProductsByNameResponse getProductsByNameRequest(@RequestPayload GetProductsByNameRequest request) {
		List<Product> productsByName = productService.getProductsByName(request.getProductName());
		GetProductsByNameResponse response = new GetProductsByNameResponse();
		List<com.imcs.syed.product.Product> productsByNameJax = new ArrayList<>();
		for (Product product : productsByName) {
			productsByNameJax.add(Parser.convertToJax(product));
			response.getListOfProducts().addAll(productsByNameJax);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsByNameAndCategoryRequest")
	@ResponsePayload
	public GetProductsByNameAndCategoryResponse getProductsByNameAndCategoryRequest(
			@RequestPayload GetProductsByNameAndCategoryRequest request) {
		List<Product> productsByNameAndCategory = productService.getProductsByNameAndCategory(request.getProductName(),
				request.getProductCategory());
		GetProductsByNameAndCategoryResponse response = new GetProductsByNameAndCategoryResponse();
		List<com.imcs.syed.product.Product> productsByNameAndCategoryJax = new ArrayList<>();
		for (Product product : productsByNameAndCategory) {
			productsByNameAndCategoryJax.add(Parser.convertToJax(product));
			response.getListOfProducts().addAll(productsByNameAndCategoryJax);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
	@ResponsePayload
	public CreateOrderResponse CreateOrderRequest(@RequestPayload CreateOrderRequest request) {
		List<Product> products = new ArrayList<>();
		CreateOrderResponse response = new CreateOrderResponse();
		for (com.imcs.syed.product.Product jaxProduct : request.getListOfProducts()) {
			products.add(Parser.convertToJav(jaxProduct));
		}
		Order newOrder = new Order();
		newOrder.setCustomerId(new Long(request.getCustomerId().longValue()));
		newOrder.setPaymentMethodId(new Long(request.getPaymentMethodId().longValue()));
		newOrder.setTotalPrice(request.getTotalPrice());
		newOrder.setListOfProducts(products);
		com.imcs.syed.product.Order jaxNewOrder = Parser.convertOrderToJax(newOrder);
		response.setOrder(jaxNewOrder);
		return response;
	}
}