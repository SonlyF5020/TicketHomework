package com.thoughtworks.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommodityParser {
    private static final String REGEX = "^(ITEM\\d{6})(-(\\d*))?$";

    public static List<Commodity> parse(String commodity) {
        List<Commodity> commodities = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(commodity);
        if (matcher.find( )) {
            String commodityCode = matcher.group(1);
            String quantity = matcher.group(3) == null ? "1" : matcher.group(3);
            for (int i = 0; i < Integer.valueOf(quantity); i++) {
                commodities.add(Commodity.getByCode(commodityCode));
            }
        }
        return commodities;
    }
}
