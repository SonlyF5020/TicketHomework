package com.thoughtworks.ticket;

public enum Commodity {
    COLA("ITEM000001", 3.00),
    BANANA("ITEM000002", 2.00),
    BADMINTON("ITEM000003", 1.00),
    BASKETBALL("ITEM000004", 30.00),
    APPLE("ITEM000005", 5.00);

    private final String code;
    private double price;

    Commodity(String code, double price) {
        this.code = code;
        this.price = price;
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
}
