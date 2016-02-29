package com.thoughtworks.ticket;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    public static List<Commodity> readFile(String filePath) {
        try {
            String ticketJSON = TicketFileReader.read(filePath);
            ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("javascript");
            List<String> commodities = ((ScriptObjectMirror) scriptEngine.eval(ticketJSON)).to(List.class);
            return convertStringtoCommodities(commodities);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Commodity> convertStringtoCommodities(List<String> commodities) {
        List<Commodity> result = new ArrayList<>();
        for (String comodityString: commodities) {
            result.addAll(CommodityParser.parse(comodityString));
        }
        return result;
    }
}
