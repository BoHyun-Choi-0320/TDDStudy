package com.banbi.productorderservice.payment.adapter;

import com.banbi.productorderservice.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
