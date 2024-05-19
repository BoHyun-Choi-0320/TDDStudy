package com.banbi.productorderservice.payment;

import com.banbi.productorderservice.order.domain.Order;
import com.banbi.productorderservice.product.domain.DiscountPolicy;
import com.banbi.productorderservice.product.domain.Product;

class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
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
    public void pay(Payment payment) {
        paymentGateway.execute(payment);
    }
}
