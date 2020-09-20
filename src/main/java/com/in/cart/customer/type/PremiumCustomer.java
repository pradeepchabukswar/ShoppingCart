package com.in.cart.customer.type;

public class PremiumCustomer implements CustomerType {

    private String name;

    public PremiumCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getCustomerType() {
        return "PREMIUM";
    }
}
