package com.thoughtworks.ticket;

public enum Commodity {
    COLA("ITEM000001"), APPLE("ITEM000002"), BADMINTON("ITEM000003");

    private final String code;

    Commodity(String code) {
        this.code = code;
    }

    public static Commodity getByCode(String commodityCode) {
        for (Commodity commodity : Commodity.values()) {
            if (commodity.code.equals(commodityCode)) {
                return commodity;
            }
        }
        return null;
    }
}
