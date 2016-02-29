package com.thoughtworks.ticket;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicketFileReaderTest {
    @Test
    public void should_read_file () {
        String filePath = getClass().getResource("/testData.json").getFile();
        String json = TicketFileReader.read(filePath);
        assertThat(json, is("{  \"test\" : \"data\"}"));
    }
}