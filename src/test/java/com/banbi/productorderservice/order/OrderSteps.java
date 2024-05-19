package com.banbi.productorderservice.order;

import com.banbi.productorderservice.order.application.service.CreateOrderRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class OrderSteps {

    public static CreateOrderRequest 상품주문요청_생성(){
        return new CreateOrderRequest(1L, 2);
    }

    public static ExtractableResponse<Response> 상품주문요청(final CreateOrderRequest request){
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();

    }
}
