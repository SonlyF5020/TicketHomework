package com.thoughtworks.ticket;

import java.util.ArrayList;
import java.util.List;

public class CommodityParser {
    public static List<Commodity> parse(String commodity) {
        List<Commodity> commodities = new ArrayList<>();
        commodities.add(Commodity.getByCode(commodity));
        return commodities;
    }
}
