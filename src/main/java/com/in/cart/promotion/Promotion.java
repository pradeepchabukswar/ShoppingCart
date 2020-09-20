package com.in.cart.promotion;

public class Promotion {

    private final int MIN;
    private final int MAX;
    private final int percent;

    public Promotion(int MIN, int MAX, int percent) {
        this.MIN = MIN;
        this.MAX = MAX;
        this.percent = percent;
    }

    public boolean isWithinPromotionRange(double amount) {
        return amount>MIN && amount<=MAX;
    }

    public double getDiscount(double totalAmount) {
        if(totalAmount<MIN) return 0;

        if(isWithinPromotionRange(totalAmount))
            return (totalAmount - MIN) * percent / 100;
        return 0;
    }
}
