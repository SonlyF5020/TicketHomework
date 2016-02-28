package com.thoughtworks.ticket;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicketFileReaderTest {
    @Test
    public void should_read_file () {
        TicketFileReader ticketFileReader = new TicketFileReader();
        String file = getClass().getResource("/testData.json").getFile();
        String json = ticketFileReader.read(file);
        assertThat(json, is("{  \"test\" : \"data\"}"));
    }
}