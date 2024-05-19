package com.banbi.productorderservice.payment.adapter;

import com.banbi.productorderservice.order.adapter.OrderRepository;
import com.banbi.productorderservice.order.domain.Order;
import com.banbi.productorderservice.payment.application.port.PaymentPort;
import com.banbi.productorderservice.payment.domain.Payment;
import com.banbi.productorderservice.product.domain.DiscountPolicy;
import com.banbi.productorderservice.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(()->new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
