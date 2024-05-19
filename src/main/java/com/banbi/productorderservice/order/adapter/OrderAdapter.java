package com.banbi.productorderservice.order.adapter;

import com.banbi.productorderservice.order.application.port.OrderPort;
import com.banbi.productorderservice.order.domain.Order;
import com.banbi.productorderservice.product.adapter.ProductRepository;
import com.banbi.productorderservice.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
