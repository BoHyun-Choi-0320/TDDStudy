package com.banbi.productorderservice.payment.adapter;

import com.banbi.productorderservice.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGateway implements PaymentGateway {
    @Override
    public void execute(int totalPrice, String cardNumber) {
        System.out.println("결제 완료");
    }
}
