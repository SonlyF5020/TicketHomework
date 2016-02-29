package com.thoughtworks.ticket;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TicketManagerTest {
    List<Commodity> commodities;

    @Before
    public void initTestData() {
        String filePath = getClass().getResource("/ticketData.json").getFile();
        commodities = TicketManager.readFile(filePath);
    }

    @Test
    public void should_read_file_to_Commodities() {
        assertThat(commodities.size(), is(10));
    }

    @Test
    public void should_read_ITEM000001_to_COLA() {
        assertThat(commodities.get(0), is(Commodity.COLA));
    }

    @Test
    public void should_read_ITEM000003_to_BADMINTON() {
        assertThat(commodities.get(6), is(Commodity.BADMINTON));
    }

    @Test
    public void should_read_ITEM000005_to_APPLE() {
        assertThat(commodities.get(9), is(Commodity.APPLE));
    }
}
