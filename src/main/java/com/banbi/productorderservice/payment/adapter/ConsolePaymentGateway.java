package com.banbi.productorderservice.payment.adapter;

import com.banbi.productorderservice.payment.domain.Payment;

public class ConsolePaymentGateway implements PaymentGateway {
    @Override
    public void execute(Payment payment) {
        System.out.println("결제 완료");
    }
}
