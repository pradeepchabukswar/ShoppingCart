package com.in.cart;

import com.in.cart.customer.type.CustomerType;
import com.in.cart.customer.type.RegularCustomer;
import com.in.cart.promotion.Promotion;
import com.in.cart.promotion.PromotionEngine;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    public static final String REGULAR = "Regular";

    ShoppingCart shoppingCart;
    CustomerType regularCustomer;

    @Before
    public void setUp() throws Exception {
        regularCustomer = new RegularCustomer(REGULAR);
        shoppingCart = new ShoppingCart(regularCustomer, 5000);
    }

    @Test
    public void shouldAddShoppingCartWithCustomerTypeAndTotalAmount() {
        assertNotNull(shoppingCart);
    }

    @Test
    public void shouldCalculateTotalOrderValue() {
        assertNotNull(shoppingCart);
        assertEquals(5000, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType() {
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        Promotion promotion = new Promotion(0, 5000, 0);
        promotions.put(regularCustomer, Arrays.asList(promotion));
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(5000, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Scenario2_WithOrderValue10000() {
        shoppingCart = new ShoppingCart(regularCustomer, 10000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        Promotion promotion = new Promotion(0, 5000, 0);
        Promotion promotion2 = new Promotion(5000, 10000, 10);
        promotions.put(regularCustomer, Arrays.asList(promotion, promotion2));
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(9500, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Scenario3_WithOrderValue5000() {
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        Promotion promotion = new Promotion(0, 5000, 0);
        Promotion promotion2 = new Promotion(5000, 10000, 10);
        promotions.put(regularCustomer, Arrays.asList(promotion, promotion2));
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(5000, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Scenario4_WithOrderValue15000() {
        shoppingCart = new ShoppingCart(regularCustomer, 15000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        Promotion promotion = new Promotion(0, 5000, 0);
        Promotion promotion2 = new Promotion(5000, 10000, 10);
        Promotion promotion3 = new Promotion(10000, Double.MAX_VALUE, 20);
        promotions.put(regularCustomer, Arrays.asList(promotion, promotion2, promotion3));
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(13500, shoppingCart.calculateTotal(), 0.001);
    }
}