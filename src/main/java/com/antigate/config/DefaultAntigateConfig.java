package com.antigate.config;

import com.antigate.config.consts.NumericCaptcha;

/**
 * @author itsimoshka
 */
public class DefaultAntigateConfig extends AntigateConfig {
    public DefaultAntigateConfig() {
        setPriceOfThousands(1.0f);
        setRussian(false);
        setMaxLength(0);
        setMinLength(0);
        setMathExpression(false);
        setNumeric(NumericCaptcha.DEFAULT);
        setRegisterSensitive(false);
        setTwoWords(false);
    }
}
