package com.prestashop.demo.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class StringMatcher {

    public String getFirstMatch(String regexp, String string, Integer groupIndex) {
        List<String> matches = getAllMatches(regexp, string, groupIndex);
        return matches.isEmpty() ? StringUtils.EMPTY : matches.get(0);
    }

    public List<String> getAllMatches(String regexp, String string, Integer groupIndex) {
        List<String> allMatches = new ArrayList<>();
        Matcher matcher = Pattern.compile(regexp).matcher(string);
        while (matcher.find()) {
            allMatches.add(matcher.group(groupIndex));
        }
        return allMatches;
    }
}