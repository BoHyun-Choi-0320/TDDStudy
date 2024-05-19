package com.banbi.productorderservice.payment.adapter;

import com.banbi.productorderservice.payment.domain.Payment;

public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
