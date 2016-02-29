package com.thoughtworks.ticket;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CommodityTest {

    @Test
    public void should_get_COLA_for_code_ITEM000001() {
        assertThat(Commodity.getByCode("ITEM000001"), is(Commodity.COLA));
    }

}