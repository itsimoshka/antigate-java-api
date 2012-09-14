package com.antigate.config;

import com.antigate.config.consts.NumericCaptcha;

/**
 * @author itsimoshka
 */
public abstract class AntigateConfig {
    private String key;
    private float priceOfThousands;
    private boolean isRussian;
    private int maxLength;
    private int minLength;
    private boolean isMathExpression;
    private NumericCaptcha numeric;
    private boolean isRegisterSensitive;
    private boolean isTwoWords;
    private static AntigateConfig defaultConfig;
    /*
    public static AntigateConfig getDefaultInstance() {
        if (defaultConfig == null) {
            defaultConfig = new AntigateConfig();
            defaultConfig.setPriceOfThousands(1.0f);
            defaultConfig.setRussian(false);
            defaultConfig.setMaxLength(1);
            defaultConfig.setMinLength(1);
            defaultConfig.setMathExpression(false);
            defaultConfig.setNumeric(NumericCaptcha.DEFAULT);
            defaultConfig.setRegisterSensitive(true);
            defaultConfig.setTwoWords(true);
        }
        return defaultConfig;
    }
    private AntigateConfig() {

    }

    */
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public float getPriceOfThousands() {
        return priceOfThousands;
    }

    public void setPriceOfThousands(float priceOfThousands) {
        this.priceOfThousands = priceOfThousands;
    }

    public boolean isRussian() {
        return isRussian;
    }

    public void setRussian(boolean russian) {
        isRussian = russian;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public boolean isMathExpression() {
        return isMathExpression;
    }

    public void setMathExpression(boolean mathExpression) {
        isMathExpression = mathExpression;
    }

    public NumericCaptcha getNumeric() {
        return numeric;
    }

    public void setNumeric(NumericCaptcha numeric) {
        this.numeric = numeric;
    }

    public boolean isRegisterSensitive() {
        return isRegisterSensitive;
    }

    public void setRegisterSensitive(boolean registerSensitive) {
        isRegisterSensitive = registerSensitive;
    }

    public boolean isTwoWords() {
        return isTwoWords;
    }

    public void setTwoWords(boolean isTwoWords) {
        this.isTwoWords = isTwoWords;
    }
}
