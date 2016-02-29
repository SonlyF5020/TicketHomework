package com.thoughtworks.ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TicketPrinter {

    public static final String MONEY_FORMAT = "#.00";

    public static String printData(List<Commodity> commodities) {
        final String[] printResult = {""};
        Map<Commodity, Long> commodityLongMap = groupCommodities(commodities);
        commodityLongMap.forEach((commodity, quantity) -> printResult[0] += printCommodity(commodity, quantity));
        return printResult[0];
    }

    private static String printCommodity(Commodity commodity, Long quantity) {
        return "名称：" + commodity.getName() +
                "，数量：" + quantity + commodity.getUnit() +
                "，单价：" + moneyOf(commodity.getPrice()) +
                "(元)，小计：" + moneyOf(Calculator.calculate(commodity, quantity)) + "(元)" +
                onSalePostfix(commodity, quantity) +
                "\n";
    }

    private static String onSalePostfix(Commodity commodity, Long quantity) {
        if (commodity.isOnSale()) {
            return "，节省" + moneyOf(Calculator.getOnSaleDiscount(commodity, quantity)) + "(元)";
        }
        return "";
    }

    private static Map<Commodity, Long> groupCommodities(List<Commodity> commodities) {
        return commodities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static String moneyOf(double price) {
        return new DecimalFormat(MONEY_FORMAT).format(price);
    }
}
