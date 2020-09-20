package com.in.cart;

import com.in.cart.customer.type.CustomerType;
import com.in.cart.customer.type.RegularCustomer;
import com.in.cart.promotion.Promotion;
import com.in.cart.promotion.PromotionEngine;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    public static final String REGULAR = "Regular";

    @Test
    public void shouldAddShoppingCartWithCustomerTypeAndTotalAmount() {
        ShoppingCart shoppingCart=new ShoppingCart(new RegularCustomer(REGULAR),5000);
        assertNotNull(shoppingCart);
    }

    @Test
    public void shouldCalculateTotalOrderValue() {
        ShoppingCart shoppingCart=new ShoppingCart(new RegularCustomer(REGULAR),5000);
        assertNotNull(shoppingCart);
        assertEquals(5000,shoppingCart.calculateTotal(),0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType() {
        RegularCustomer regularCustomer = new RegularCustomer(REGULAR);
        ShoppingCart shoppingCart=new ShoppingCart(regularCustomer,5000);
        Map<CustomerType, List<Promotion>> promotions= new HashMap();
        Promotion promotion=new Promotion(0,5000,0);
        promotions.put(regularCustomer, Arrays.asList(promotion));
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(5000,shoppingCart.calculateTotal(),0.001);
    }
}