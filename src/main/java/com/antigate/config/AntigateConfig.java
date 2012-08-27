package com.antigate.config;

/**
 * @author itsimoshka
 */
public class AntigateConfig {
    private static String key;

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        AntigateConfig.key = key;
    }
}
