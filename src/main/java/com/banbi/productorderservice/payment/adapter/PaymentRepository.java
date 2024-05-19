package com.banbi.productorderservice.payment.adapter;

import com.banbi.productorderservice.payment.domain.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private Map<Long, Payment> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(Payment payment) {
        payment.assignId(++sequence);
        persistence.put(payment.getId(), payment);
    }
}
