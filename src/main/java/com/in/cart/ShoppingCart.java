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
        double discount = 0;
        if (promotionEngine != null)
            discount = promotionEngine.calculateDiscount(customerType, totalAmount);

        return totalAmount - discount;
    }

    public void setPromotionEngine(PromotionEngine promotionEngine) {
        this.promotionEngine = promotionEngine;
    }
}
