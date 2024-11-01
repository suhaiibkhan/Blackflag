package com.BlackFlag.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BlackFlag.order.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
