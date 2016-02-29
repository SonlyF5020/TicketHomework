package com.thoughtworks.ticket;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculator {
    public static final int QUANTITY_LIMIT = 2;
    public static final double INIT_DISCOUNT = 0.00;
    public static final double INIT_PRICE = 0.00;

    public static double calculate(List<Commodity> commodities) {
        double price = getInitialPrice(commodities);
        price -= getTwoPlusOneDiscounts(commodities);
        return price;
    }

    private static double getTwoPlusOneDiscounts(List<Commodity> commodities) {
        final double[] twoPlusOneDiscount = {0};
        Map<Commodity, Long> commodityMap = commodities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        commodityMap.forEach((k, v) -> {
            twoPlusOneDiscount[0] += getTwoPlusOneDiscount(k, v);
        });
        return twoPlusOneDiscount[0];
    }

    private static double getTwoPlusOneDiscount(Commodity commodity, Long quantity) {
        return commodity.isTwoPlusOne() && quantity >= QUANTITY_LIMIT ? commodity.getPrice() : INIT_DISCOUNT;
    }

    private static double getInitialPrice(List<Commodity> commodities) {
        double price =  INIT_PRICE;
        for (Commodity commodity : commodities) {
            price += commodity.getPrice();
        }
        return price;
    }
}
