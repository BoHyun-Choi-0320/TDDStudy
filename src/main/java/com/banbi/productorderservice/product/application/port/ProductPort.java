package com.banbi.productorderservice.product.application.port;

import com.banbi.productorderservice.product.domain.Product;

public interface ProductPort {
    void save(final Product product);

    Product getProduct(Long productId);
}
