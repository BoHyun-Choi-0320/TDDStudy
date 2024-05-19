package com.banbi.productorderservice.payment;

interface PaymentGateway {
    void execute(Payment payment);
}
