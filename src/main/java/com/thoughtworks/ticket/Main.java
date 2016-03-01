package com.thoughtworks.ticket;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        run("normal.json");
        run("two_plus_one.json");
        run("on_sale.json");
        run("two_plus_one__on_sale.json");
    }

    private static void run(String fileName) {
        String filePath = Main.class.getResource("/" + fileName).getFile();
        List<Commodity> commodities = TicketManager.readFile(filePath);
        System.out.println(TicketPrinter.print(commodities) + "\n\n");
    }
}
