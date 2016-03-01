package com.thoughtworks.ticket;

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
        return commodity.isOnSale() ? "，节省" + moneyOf(Calculator.getOnSaleDiscount(commodity, quantity)) + "(元)" : "";
    }

    private static Map<Commodity, Long> groupCommodities(List<Commodity> commodities) {
        return commodities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static String moneyOf(double price) {
        return new DecimalFormat(MONEY_FORMAT).format(price);
    }

    public static String printHeader() {
        return "***<没钱赚商店>购物清单***\n";
    }

    public static String printSummary(List<Commodity> commodities) {
        return "----------------------\n" +
                "总计：" +
                moneyOf(Calculator.calculate(commodities)) +
                "(元)\n" +
                printDiscountSummary(commodities) +
                "**********************\n";
    }

    private static String printDiscountSummary(List<Commodity> commodities) {
        double totalDiscount = Calculator.getTotalDiscount(commodities);
        return totalDiscount > 0 ? "节省：" +
                moneyOf(totalDiscount) +
                "(元)\n" : "";
    }

    public static String printTwoPlusOneSummary(List<Commodity> commodities) {
        return "买二赠一商品：\n" + "名称：羽毛球，数量：1个\n";
    }
}
