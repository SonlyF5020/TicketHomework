package com.thoughtworks.ticket;

public enum Commodity {
    COLA("ITEM000001", "可口可乐", "瓶", 3.00, false, false),
    BANANA("ITEM000002", "香蕉", "个", 2.00, false, false),
    BADMINTON("ITEM000003", "羽毛球", "个", 1.00, true, false),
    BASKETBALL("ITEM000004", "篮球", "个", 100.00, false, true),
    APPLE("ITEM000005", "苹果", "个", 5.00, false, false);

    private final String code;
    private String name;
    private String unit;
    private double price;
    private final boolean onSale;
    private final boolean twoPlusOne;

    Commodity(String code, String name, String unit, double price, boolean twoPlusOne, boolean onSale) {
        this.code = code;
        this.name = name;
        this.unit = unit;
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

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}
