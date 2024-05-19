    package com.banbi.productorderservice.product.domain;

    public enum DiscountPolicy {
        NONE{
            @Override
            int applyDiscount(final int price) {
                return price;
            }
        },
        FIX_1000_AMOUNT{
            @Override
            int applyDiscount(final int price) {
                return Math.max(price - 1000, 0);
                // price - 1000 < 0 ? 0 : price -1000와 Math.max(price - 1000, 0)은 동일
            }
        };

        abstract int applyDiscount(final int price);
    }
