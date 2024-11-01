package com.BlackFlag.Orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BlackFlag.Orders.model.Order;
import com.BlackFlag.Orders.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

 @Autowired
 private OrderService orderService;

 @PostMapping
 public ResponseEntity<Order> createOrder(@RequestBody Order order) {
     Order newOrder = orderService.createOrder(order);
     return ResponseEntity.ok(newOrder);
 }

 @GetMapping
 public ResponseEntity<List<Order>> getAllOrders() {
     return ResponseEntity.ok(orderService.getAllOrders());
 }

 @GetMapping("/{id}")
 public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
     Order order = orderService.getOrderById(id);
     return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
 }

 @PutMapping("/{id}")
 public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
     Order updatedOrder = orderService.updateOrder(id, orderDetails);
     return updatedOrder != null ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
     orderService.deleteOrder(id);
     return ResponseEntity.noContent().build();
 }
}
