package com.banbi.productorderservice.payment;

import com.banbi.productorderservice.payment.adapter.ConsolePaymentGateway;
import com.banbi.productorderservice.payment.adapter.PaymentAdapter;
import com.banbi.productorderservice.payment.adapter.PaymentGateway;
import com.banbi.productorderservice.payment.adapter.PaymentRepository;
import com.banbi.productorderservice.payment.application.port.PaymentPort;
import com.banbi.productorderservice.payment.application.service.PaymentRequest;
import com.banbi.productorderservice.payment.application.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    private PaymentService paymentService;
    private PaymentPort paymentPort;

    @BeforeEach
    void setUp() {
        PaymentGateway paymentGateway = new ConsolePaymentGateway();
        PaymentRepository paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void 상품주문() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        final PaymentRequest request = new PaymentRequest(orderId, cardNumber);
        paymentService.payment(request);
    }

}
