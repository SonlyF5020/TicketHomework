package com.thoughtworks.ticket;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommodityParserTest {
    @Test
    public void should_parse_ITEM000001_to_one_cola() {
        List<Commodity> commodities = CommodityParser.parse("ITEM000001");
        assertThat(commodities.size(), is(1));
        assertThat(commodities.get(0), is(Commodity.COLA));
    }
}
