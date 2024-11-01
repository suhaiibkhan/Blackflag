package com.BlackFlag.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BlackFlag.order.models.Order;
import com.BlackFlag.order.repository.OrderRepository;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order updateOrder(Long id, Order updatedOrder) {
		return orderRepository.findById(id).map(order -> {
			order.setCustomerId(updatedOrder.getCustomerId());
//			order.setOrderDate(updatedOrder.getOrderDate());
			order.setProcessedBy(updatedOrder.getProcessedBy());
			order.setOrderStatus(updatedOrder.getOrderStatus());
			order.setTotalAmount(updatedOrder.getTotalAmount());
			return orderRepository.save(order);
		}).orElseThrow(() -> new RuntimeException("Order not found"));
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
