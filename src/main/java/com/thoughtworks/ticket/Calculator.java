package com.thoughtworks.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculator {
    public static final int QUANTITY_LIMIT = 2;
    public static final double INIT_DISCOUNT = 0.00;
    public static final double INIT_PRICE = 0.00;
    public static final double DISCOUNT_RATE = 0.05;

    public static double calculate(List<Commodity> commodities) {
        double price = getInitialPrice(commodities);
        price -= getTwoPlusOneDiscounts(commodities);
        price -= getOnSaleDiscounts(commodities);
        return price;
    }

    private static double getOnSaleDiscounts(List<Commodity> commodities) {
        final double[] twoPlusOneDiscount = {0};
        Map<Commodity, Long> commodityMap = groupCommodities(commodities);
        commodityMap.forEach((commodity, quantity) -> twoPlusOneDiscount[0] += getOnSaleDiscount(commodity, quantity));
        return twoPlusOneDiscount[0];
    }

    private static double getOnSaleDiscount(Commodity commodity, Long quantity) {
        return commodity.isOnSale() ? (commodity.getPrice() * quantity * DISCOUNT_RATE) : INIT_DISCOUNT;
    }

    private static double getTwoPlusOneDiscounts(List<Commodity> commodities) {
        final double[] twoPlusOneDiscount = {0};
        Map<Commodity, Long> commodityMap = groupCommodities(commodities);
        commodityMap.forEach((commodity, quantity) -> twoPlusOneDiscount[0] += getTwoPlusOneDiscount(commodity, quantity));
        return twoPlusOneDiscount[0];
    }

    private static double getTwoPlusOneDiscount(Commodity commodity, Long quantity) {
        return commodity.isTwoPlusOne() && quantity >= QUANTITY_LIMIT ? commodity.getPrice() : INIT_DISCOUNT;
    }

    private static double getInitialPrice(List<Commodity> commodities) {
        double price = INIT_PRICE;
        for (Commodity commodity : commodities) {
            price += commodity.getPrice();
        }
        return price;
    }

    private static Map<Commodity, Long> groupCommodities(List<Commodity> commodities) {
        return commodities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static double calculate(Commodity commodity, long
            quantity) {
        List<Commodity> commodities = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            commodities.add(commodity);
        }
        return calculate(commodities);
    }
}
