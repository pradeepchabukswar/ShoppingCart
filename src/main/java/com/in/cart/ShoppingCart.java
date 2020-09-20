package com.in.cart;

import com.in.cart.customer.type.CustomerType;
import com.in.cart.promotion.PromotionEngine;

public class ShoppingCart {

    private final CustomerType customerType;
    private final double totalAmount;

    private PromotionEngine promotionEngine;

    public ShoppingCart(CustomerType customerType, double totalAmount) {

        this.customerType = customerType;
        this.totalAmount = totalAmount;
    }

    public double calculateTotal() {
        return totalAmount-promotionEngine.calculateDiscount(customerType,totalAmount);
    }

    public void setPromotionEngine(PromotionEngine promotionEngine) {
        this.promotionEngine = promotionEngine;
    }
}
