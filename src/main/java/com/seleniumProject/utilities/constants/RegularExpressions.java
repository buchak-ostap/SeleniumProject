package com.seleniumProject.utilities.constants;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j
public class RegularExpressions {
    //regex and replacements shared

    public static final String priceWithoutCurrencyReplaceAll = "[\\p{Sc}a-zA-Z,! ?]";
    public static final String priceRegex = "\\d+((,\\d+)+)?(.\\d+)?(.\\d+)?(,\\d+)?";
    public static final String url = "\"(\\\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])\"";
    public static final String XERO_URL = "";
    public static final String bySymbol = "(?!^)";
    public static final String sixDigitsCode = "[0-9]{6}";
    public static final String hrefHtmlElement = "<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1";


    public static String fullMatch(String regex, String string) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        if(m.find()) return m.group();

        log.error("No matches found!");
        return null;
    }

    public static List<String> allFullMatches(String regex, String string) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        List matches = new ArrayList();
        while (m.find()) { matches.add(m.group());}

        if(matches.isEmpty()) { log.error("No matches found!"); }
        return matches;
    }
}

