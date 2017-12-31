package com.imcs.syed.dao;

import org.springframework.data.repository.CrudRepository;

import com.imcs.syed.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	@SuppressWarnings("unchecked")
	Order save(Order newOrder);

}
