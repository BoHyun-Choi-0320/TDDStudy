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
        final PaymentRequest request = PaymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }

}
