package com.banbi.productorderservice.order.application.port;

import com.banbi.productorderservice.order.domain.Order;
import com.banbi.productorderservice.product.domain.Product;

public interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
