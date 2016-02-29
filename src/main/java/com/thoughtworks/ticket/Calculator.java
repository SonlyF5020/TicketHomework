package com.thoughtworks.ticket;

import java.util.List;

public class Calculator {
    public static double calculate(List<Commodity> commodities) {
        double price = 0.00;
        for (Commodity commodity : commodities) {
           price += commodity.getPrice();
        }
        return price;
    }
}
