package com.thoughtworks.ticket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TicketPrinterTest {
    List<Commodity> commodities;

    @Before
    public void initCommodities() {
        commodities = new ArrayList<>();
    }

    @Test
    public void should_print_normal_commodities() {
        commodities.add(Commodity.COLA);
        commodities.add(Commodity.COLA);
        commodities.add(Commodity.COLA);
        String printData = TicketPrinter.printData(commodities);
        assertThat(printData, is("名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n"));
    }

    @Test
    public void should_print_two_plus_one_commodities() {
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        String printData = TicketPrinter.printData(commodities);
        assertThat(printData, is("名称：羽毛球，数量：3个，单价：1.00(元)，小计：2.00(元)\n"));
    }

    @Test
    public void should_print_on_sale_commodities() {
        commodities.add(Commodity.BASKETBALL);
        String printData = TicketPrinter.printData(commodities);
        assertThat(printData, is("名称：篮球，数量：1个，单价：100.00(元)，小计：95.00(元)，节省5.00(元)\n"));
    }

    @Test
    public void should_print_store_header() {
        String header = TicketPrinter.printHeader();
        assertThat(header, is("***<没钱赚商店>购物清单***\n"));
    }

    @Test
    public void should_print_price_summary_for_normal_commodities() {
        commodities.add(Commodity.COLA);
        commodities.add(Commodity.COLA);
        commodities.add(Commodity.COLA);
        String summary = TicketPrinter.printSummary(commodities);
        assertThat(summary, is("----------------------\n总计：9.00(元)\n**********************\n"));
    }

    @Test
    public void should_print_price_summary_for_two_plus_one_commodities() {
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        String summary = TicketPrinter.printSummary(commodities);
        assertThat(summary, is("----------------------\n总计：2.00(元)\n节省：1.00(元)\n**********************\n"));
    }

    @Test
    public void should_print_two_plus_one_summary_for_two_plus_one_commodities() {
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        String summary = TicketPrinter.printTwoPlusOneSummary(commodities);
        assertThat(summary, is("----------------------\n" +
                "买二赠一商品：\n" +
                "名称：羽毛球，数量：1个\n"));
    }

    @Test
    public void should_print_two_plus_one_summary_for_two_plus_one_more_commodities() {
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        String summary = TicketPrinter.printTwoPlusOneSummary(commodities);
        assertThat(summary, is("----------------------\n" +
                "买二赠一商品：\n" +
                "名称：羽毛球，数量：2个\n"));
    }

    @Test
    public void should_print_all_info() {
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        String allInfo = TicketPrinter.print(commodities);
        assertThat(allInfo, is("***<没钱赚商店>购物清单***\n" +
                "名称：羽毛球，数量：7个，单价：1.00(元)，小计：5.00(元)\n" +
                "----------------------\n" +
                "买二赠一商品：\n" +
                "名称：羽毛球，数量：2个\n" +
                "----------------------\n" +
                "总计：5.00(元)\n" +
                "节省：2.00(元)\n" +
                "**********************\n"));
    }
}
