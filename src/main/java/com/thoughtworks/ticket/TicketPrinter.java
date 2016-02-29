package com.thoughtworks.ticket;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TicketPrinter {
    public static String printData(List<Commodity> commodities) {
        Map<Commodity, Long> commodityLongMap = groupCommodities(commodities);


        return "";
    }

    private static Map<Commodity, Long> groupCommodities(List<Commodity> commodities) {
        return commodities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
