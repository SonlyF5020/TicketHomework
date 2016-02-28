package com.thoughtworks.ticket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TicketFileReader {

    public String read(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.reduce((a, b) -> a + b).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
