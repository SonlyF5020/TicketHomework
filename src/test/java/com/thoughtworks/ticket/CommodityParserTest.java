package com.thoughtworks.ticket;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CommodityParserTest {
    @Test
    public void should_parse_ITEM000001_to_one_cola() {
        List<Commodity> commodities = CommodityParser.parse("ITEM000001");
        assertThat(commodities.size(), is(1));
        assertThat(commodities.get(0), is(Commodity.COLA));
    }

    @Test
    public void should_parse_ITEM000001_minus_2_to_two_cola() {
        List<Commodity> commodities = CommodityParser.parse("ITEM000001-2");
        assertThat(commodities.size(), is(2));
        assertEquals(commodities.get(0), Commodity.COLA);
        assertEquals(commodities.get(1), Commodity.COLA);
    }
}
