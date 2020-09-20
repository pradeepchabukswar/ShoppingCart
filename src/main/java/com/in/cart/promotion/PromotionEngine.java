package com.in.cart.promotion;

import com.in.cart.customer.type.CustomerType;

import java.util.List;
import java.util.Map;

public class PromotionEngine {
    private Map<CustomerType, List<Promotion>> promotions;

    public PromotionEngine(Map<CustomerType, List<Promotion>> promotions) {
        this.promotions = promotions;
    }
}
