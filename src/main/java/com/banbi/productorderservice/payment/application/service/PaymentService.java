package com.banbi.productorderservice.payment.application.service;

import com.banbi.productorderservice.order.domain.Order;
import com.banbi.productorderservice.payment.application.port.PaymentPort;
import com.banbi.productorderservice.payment.domain.Payment;

public class PaymentService {
    private final PaymentPort paymentPort;

    public PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(final PaymentRequest request) {
        Order order = paymentPort.getOrder(request.orderId());

        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment);
        paymentPort.save(payment);
    }
}
