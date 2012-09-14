package com.antigate.responses;

/**
 * @author itsimoshka
 */
public class SendFileResponse implements Response {
    private String captchaID;

    public SendFileResponse(final String captchaID) {
        this.captchaID = captchaID;
    }

    public String getCaptchaID() {
        return captchaID;
    }

}
