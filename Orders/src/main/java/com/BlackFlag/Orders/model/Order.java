package com.BlackFlag.Orders.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String customerName;

 @Column(nullable = false)
 private LocalDateTime orderTime;

 @Column(nullable = false)
 private Double totalAmount;

 @ElementCollection
 private List<String> items; 

 // Getters and Setters

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getCustomerName() {
     return customerName;
 }

 public void setCustomerName(String customerName) {
     this.customerName = customerName;
 }

 public LocalDateTime getOrderTime() {
     return orderTime;
 }

 public void setOrderTime(LocalDateTime orderTime) {
     this.orderTime = orderTime;
 }

 public Double getTotalAmount() {
     return totalAmount;
 }

 public void setTotalAmount(Double totalAmount) {
     this.totalAmount = totalAmount;
 }

 public List<String> getItems() {
     return items;
 }

 public void setItems(List<String> items) {
     this.items = items;
 }
}

