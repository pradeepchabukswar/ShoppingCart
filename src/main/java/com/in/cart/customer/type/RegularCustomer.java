package com.in.cart.customer.type;

public class RegularCustomer implements CustomerType {

    private String name;

    public RegularCustomer(String name) {

        this.name = name;
    }

    @Override
    public String getCustomerType() {
        return "REGULAR";
    }
}
