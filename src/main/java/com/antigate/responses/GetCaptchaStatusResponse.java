package com.antigate.responses;

import com.antigate.response.AntigateCaptchaStatus;

/**
 * @author itsimoshka
 */
public class GetCaptchaStatusResponse implements Response {
    private AntigateCaptchaStatus captchaStatus;
    private String captchaWord;

    public GetCaptchaStatusResponse(final String captchaWord, AntigateCaptchaStatus status) {
        this.captchaWord = captchaWord;
        this.captchaStatus = status;

    }
    public AntigateCaptchaStatus getCaptchaStatus() {
        return captchaStatus;
    }

    public void setCaptchaStatus(AntigateCaptchaStatus captchaStatus) {
        this.captchaStatus = captchaStatus;
    }

    public String getCaptchaWord() {
        return captchaWord;
    }

    public void setCaptchaWord(String captchaWord) {
        this.captchaWord = captchaWord;
    }
}
