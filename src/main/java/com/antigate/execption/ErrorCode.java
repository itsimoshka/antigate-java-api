package com.antigate.execption;

/**
 * @author itsimoshka
 */
public enum ErrorCode {
    /**
     * User key has bad format
     */
    ERROR_WRONG_USER_KEY("ERROR_WRONG_USER_KEY"),
    /**
     * Wrong user key
     */
    ERROR_KEY_DOES_NOT_EXIST("ERROR_KEY_DOES_NOT_EXIST"),
    /**
     * There are no free employees in antigate
     * You can increase bet
     */
    ERROR_NO_SLOT_AVAILABLE("ERROR_NO_SLOT_AVAILABLE"),
    ERROR_ZERO_CAPTCHA_FILESIZE("ERROR_ZERO_CAPTCHA_FILESIZE"),
    /**
     * Captcha size is more then 100 Kb
     */
    ERROR_TOO_BIG_CAPTCHA_FILESIZE("ERROR_TOO_BIG_CAPTCHA_FILESIZE"),
    /**
     * User's balance is <=0$
     */
    ERROR_ZERO_BALANCE("ERROR_ZERO_BALANCE"),
    /**
     * Wrong ip
     * Can be changed in settings
     */
    ERROR_IP_NOT_ALLOWED("ERROR_IP_NOT_ALLOWED"),
    /**
     * Too hard captcha
     */
    ERROR_CAPTCHA_UNSOLVABLE("ERROR_CAPTCHA_UNSOLVABLE"),
    /**
     * Ends attempts in "100% recognise mode"
     */
    ERROR_BAD_DUPLICATES("ERROR_BAD_DUPLICATES"),
    /**
     * Put "method" parameter in request
     */
    ERROR_NO_SUCH_METHOD("ERROR_NO_SUCH_METHOD"),
    /**
     * There is not JPEG, GIF or PNG format
     */
    ERROR_IMAGE_TYPE_NOT_SUPPORTED("ERROR_IMAGE_TYPE_NOT_SUPPORTED"),
    UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION");
    private String code;
    ErrorCode(final String code) {
        this.code = code;
    }
}
