package com.in.cart;

import com.in.cart.customer.type.CustomerType;
import com.in.cart.customer.type.PremiumCustomer;
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
    public static final String PREMIUM = "Premium";

    ShoppingCart shoppingCart;
    CustomerType regularCustomer;
    CustomerType premiumCustomer;

    @Before
    public void setUp() throws Exception {
        premiumCustomer = new PremiumCustomer(PREMIUM);
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
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Regular() {
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        Promotion promotion = new Promotion(0, 5000, 0);
        promotions.put(regularCustomer, Arrays.asList(promotion));
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(5000, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Regular_Scenario2_WithOrderValue10000() {
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
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Regular_Scenario3_WithOrderValue5000() {
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        Promotion promotion = new Promotion(0, 5000, 0);
        Promotion promotion2 = new Promotion(5000, 10000, 10);
        promotions.put(regularCustomer, Arrays.asList(promotion, promotion2));
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(5000, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Regular_Scenario4_WithOrderValue15000() {
        shoppingCart = new ShoppingCart(regularCustomer, 15000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        preparePromotionsForRegularCustomer(promotions);
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(13500, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldBeAbleToApplyDiscountBasedOnCustomerType_Regular_Scenario5_WithOrderValue10000() {
        shoppingCart = new ShoppingCart(regularCustomer, 10000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        preparePromotionsForRegularCustomer(promotions);
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(9500, shoppingCart.calculateTotal(), 0.001);
    }

    private void preparePromotionsForRegularCustomer(Map<CustomerType, List<Promotion>> promotions) {
        Promotion promotion = new Promotion(0, 5000, 0);
        Promotion promotion2 = new Promotion(5000, 10000, 10);
        Promotion promotion3 = new Promotion(10000, Double.MAX_VALUE, 20);
        promotions.put(regularCustomer, Arrays.asList(promotion, promotion2, promotion3));
    }

    private void preparePromotionsForPremiumCustomer(Map<CustomerType, List<Promotion>> promotions) {
        Promotion promotion2 = new Promotion(4000, 8000, 15);
        Promotion promotion4 = new Promotion(12000, Double.MAX_VALUE, 30);
        Promotion promotion3 = new Promotion(8000, 12000, 20);
        Promotion promotion = new Promotion(0, 4000, 10);
        promotions.put(premiumCustomer, Arrays.asList(promotion, promotion2, promotion3,promotion4));
    }

    @Test
    public void shouldAbleToAddNewCustomerType_Premium_WithCorrespondingPromotions_Scenario1() {
        shoppingCart = new ShoppingCart(premiumCustomer, 4000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        preparePromotionsForPremiumCustomer(promotions);
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(3600, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldAbleToAddNewCustomerType_Premium_WithCorrespondingPromotions_Scenario2() {
        shoppingCart = new ShoppingCart(premiumCustomer, 8000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        preparePromotionsForPremiumCustomer(promotions);
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(7000, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldAbleToAddNewCustomerType_Premium_WithCorrespondingPromotions_Scenario3() {
        shoppingCart = new ShoppingCart(premiumCustomer, 12000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        preparePromotionsForPremiumCustomer(promotions);
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(10200, shoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldAbleToAddNewCustomerType_Premium_WithCorrespondingPromotions_Scenario4() {
        shoppingCart = new ShoppingCart(premiumCustomer, 20000);
        Map<CustomerType, List<Promotion>> promotions = new HashMap();
        preparePromotionsForPremiumCustomer(promotions);
        PromotionEngine promotionEngine = new PromotionEngine(promotions);
        shoppingCart.setPromotionEngine(promotionEngine);
        assertEquals(15800, shoppingCart.calculateTotal(), 0.001);

    }

}