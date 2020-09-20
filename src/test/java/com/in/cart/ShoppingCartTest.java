package com.in.cart;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    @Test
    public void shouldAddShoppingCartWithCustomerTypeAndTotalAmount() {
        ShoppingCart shoppingCart=new ShoppingCart("REGULAR",5000);
        assertNotNull(shoppingCart);
    }

    @Test
    public void name() {

    }
}