/*
@author https://yunp.top
 */
package top.yunp.asws.utils;

import java.util.HashMap;
import java.util.Map;

public class ArgsParser {

    private static final Map<String, String> argsMap = new HashMap<>();

    public static void parseArgs(String[] args) {
        for (String arg : args) {
            var tokens = arg.split("=");
            if (tokens.length == 2) {
                argsMap.put(tokens[0], tokens[1]);
            }
        }
    }

    public static String getArg(String name) {
        return argsMap.get(name);
    }
}
