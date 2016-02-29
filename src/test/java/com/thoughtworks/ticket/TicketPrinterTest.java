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
        commodities.add(Commodity.BANANA);
        commodities.add(Commodity.BANANA);
        String printData = TicketPrinter.printData(commodities);
        assertThat(printData, is("名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n" +
                "名称：香蕉，数量：2个，单价：1.00(元)，小计：2.00(元)\n"));
    }
}
