package com.in.cart;
public class ShoppingCart {

    private final String customerType;
    private final double totalAmount;

    public ShoppingCart(String customerType, double totalAmount) {

        this.customerType = customerType;
        this.totalAmount = totalAmount;
    }
}
