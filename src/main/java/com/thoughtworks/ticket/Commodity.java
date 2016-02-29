package com.thoughtworks.ticket;

public enum Commodity {
    COLA("ITEM000001", 3.00, false, false),
    BANANA("ITEM000002", 2.00, false, false),
    BADMINTON("ITEM000003", 1.00, true, false),
    BASKETBALL("ITEM000004", 100.00, false, true),
    APPLE("ITEM000005", 5.00, false, false);

    private final String code;
    private double price;
    private final boolean onSale;
    private final boolean twoPlusOne;

    Commodity(String code, double price, boolean twoPlusOne, boolean onSale) {
        this.code = code;
        this.price = price;
        this.twoPlusOne = twoPlusOne;
        this.onSale = onSale;
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

    public boolean isOnSale() {
        return onSale;
    }
}
