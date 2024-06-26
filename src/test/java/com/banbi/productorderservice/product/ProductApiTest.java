package com.banbi.productorderservice.product;

import com.banbi.productorderservice.ApiTest;
import com.banbi.productorderservice.product.adapter.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductApiTest extends ApiTest {
    private final ProductSteps productSteps = new ProductSteps();

    @Autowired
    ProductRepository productRespository;

    @Test
    void 상품등록(){
        final var request = productSteps.상품등록요청_생성();
        // API 요청
        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회(){
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        final var response = ProductSteps.상품조회(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    @Test
    void 상품수정() {
        //상품 등록
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final long productId = 1L;

        //상품 수정 요청
        final var response = ProductSteps.상품수정요청(productId);

        //상품 수정 검증
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRespository.findById(productId).get().getName()).isEqualTo("상품 수정");
    }

}