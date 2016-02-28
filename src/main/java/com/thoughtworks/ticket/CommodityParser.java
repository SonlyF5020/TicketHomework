package com.thoughtworks.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommodityParser {
    private static final String REGEX = "/^(ITEM\\d{6})-(\\d)$/";

    public static List<Commodity> parse(String commodity) {
        List<Commodity> commodities = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(commodity);
        System.out.println(matcher.matches());
        commodities.add(Commodity.getByCode(commodity));
        return commodities;
    }
}
