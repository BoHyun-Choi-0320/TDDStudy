package com.banbi.productorderservice.payment.application.port;

import com.banbi.productorderservice.order.domain.Order;
import com.banbi.productorderservice.payment.domain.Payment;

public interface PaymentPort {

    Order getOrder(Long orderId);

    void save(Payment payment);

    void pay(int totalPrice, String cardNumber);
}
