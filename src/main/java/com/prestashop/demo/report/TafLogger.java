package com.prestashop.demo.report;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;

@Slf4j
@UtilityClass
public class TafLogger {

    private static final String SLF4J_STRING_FORMAT = "{}";
    private static final String STRING_FORMAT_SPECIFIER = "%s";

    public void fail(String message) {
        log.error(message);
        System.out.println(buildSoutMessage(LogLevel.ERROR, message));
    }

    public void info(String message) {
        log.info(message);
        System.out.println(buildSoutMessage(LogLevel.INFO, message));
    }

    public void info(String messageFormat, Object... params) {
        log.info(String.format(messageFormat, params));
        System.out.println(buildSoutMessage(LogLevel.INFO, formatSoutMessage(messageFormat, params)));
    }

    public void fail(String messageFormat, Object... params) {
        log.error(String.format(messageFormat, params));
        System.out.println(buildSoutMessage(LogLevel.ERROR, formatSoutMessage(messageFormat, params)));
    }

    private static String buildSoutMessage(LogLevel level, String msg) {
        return level + ": " + msg;
    }

    private static String formatSoutMessage(String message, Object... args) {
        return String.format(message.replace(SLF4J_STRING_FORMAT, STRING_FORMAT_SPECIFIER), args);
    }
}