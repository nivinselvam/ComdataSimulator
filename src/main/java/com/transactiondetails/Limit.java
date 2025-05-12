package com.transactiondetails;

public class Limit {
    private String maxDollar;
    private String maxQuantity;

    // Getters and Setters
    public String getMaxDollar() {
        return maxDollar;
    }

    public void setMaxDollar(String maxDollar) {
        this.maxDollar = maxDollar;
    }

    public String getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(String maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "maxDollar='" + maxDollar + '\'' +
                ", maxQuantity='" + maxQuantity + '\'' +
                '}';
    }
}
