package com.banbi.productorderservice.order;

import com.banbi.productorderservice.ApiTest;
import com.banbi.productorderservice.order.adapter.OrderRepository;
import com.banbi.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderApiTest extends ApiTest {

    private final OrderSteps orderSteps = new OrderSteps();

    @Autowired
    OrderRepository orderRepository;

    @Test
    void 상품주문(){
        // 상품주문 요청 생성
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

        final var request = orderSteps.상품주문요청_생성();

        // API 요청
        final var response = OrderSteps.상품주문요청(request);

        //검증
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
