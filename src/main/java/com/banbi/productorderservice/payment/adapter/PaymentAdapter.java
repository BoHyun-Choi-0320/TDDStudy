package com.banbi.productorderservice.payment.adapter;

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

    public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 2);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);

    }
}
