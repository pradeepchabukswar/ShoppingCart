package com.in.cart.promotion;

import com.in.cart.customer.type.CustomerType;

import java.util.List;
import java.util.Map;

public class PromotionEngine {
    private Map<CustomerType, List<Promotion>> promotionsByCustomerType;

    public PromotionEngine(Map<CustomerType, List<Promotion>> promotionsByCustomerType) {
        this.promotionsByCustomerType = promotionsByCustomerType;
    }

    public double calculateDiscount(CustomerType customerType, double totalAmount) {
        List<Promotion> promotions = this.promotionsByCustomerType.get(customerType);
        double discount = 0;
        for (Promotion promotion : promotions) {
            discount += promotion.getDiscount(totalAmount);
        }
        return 0;
    }
}
