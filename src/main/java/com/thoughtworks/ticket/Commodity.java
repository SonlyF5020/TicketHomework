package com.thoughtworks.ticket;

public enum Commodity {
    COLA("ITEM000001", 3.00, false),
    BANANA("ITEM000002", 2.00, false),
    BADMINTON("ITEM000003", 1.00, true),
    BASKETBALL("ITEM000004", 30.00, false),
    APPLE("ITEM000005", 5.00, false);

    private final String code;
    private double price;
    private final boolean twoPlusOne;

    Commodity(String code, double price, boolean twoPlusOne) {
        this.code = code;
        this.price = price;
        this.twoPlusOne = twoPlusOne;
    }

    public static Commodity getByCode(String commodityCode) {
        for (Commodity commodity : Commodity.values()) {
            if (commodity.code.equals(commodityCode)) {
                return commodity;
            }
        }
        return null;
    }

    public double getPrice() {
        return price;
    }

    public boolean isTwoPlusOne() {
        return twoPlusOne;
    }
}
