package com.BlackFlag.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BlackFlag.payments.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
