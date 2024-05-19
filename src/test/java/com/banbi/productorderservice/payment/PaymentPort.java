package com.banbi.productorderservice.payment;

import com.banbi.productorderservice.order.domain.Order;

interface PaymentPort {

    Order getOrder(Long orderId);

    void save(Payment payment);

    void pay(Payment payment);
}
