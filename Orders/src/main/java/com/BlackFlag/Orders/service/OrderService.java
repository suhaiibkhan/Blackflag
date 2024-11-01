package com.BlackFlag.Orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BlackFlag.Orders.model.Order;
import com.BlackFlag.Orders.repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order createOrder(Order order) {
		order.setOrderTime(LocalDateTime.now());
		return orderRepository.save(order);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	public Order updateOrder(Long id, Order orderDetails) {
		Order order = orderRepository.findById(id).orElse(null);
		if (order != null) {
			order.setCustomerName(orderDetails.getCustomerName());
			order.setTotalAmount(orderDetails.getTotalAmount());
			order.setItems(orderDetails.getItems());
			return orderRepository.save(order);
		}
		return null;
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
