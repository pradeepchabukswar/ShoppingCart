package com.in.cart.promotion;

public class Promotion {

    private final int start;
    private final int end;
    private final int percent;

    public Promotion(int start, int end, int percent) {
        this.start = start;
        this.end = end;
        this.percent = percent;
    }

    public double getDiscount(double totalAmount) {
        return 0;
    }
}
