package com.antigate.config.consts;

/**
 * @author itsimoshka
 */
public enum NumericCaptcha {
    DEFAULT("0"),
    ONLY_NUMERIC("1"),
    WITHOUT_NUMERIC("2");
    private String numericCode;

    NumericCaptcha(final String numericCode){
        this.numericCode = numericCode;
    }

    public String getNumericCode() {
        return numericCode;
    }
}
