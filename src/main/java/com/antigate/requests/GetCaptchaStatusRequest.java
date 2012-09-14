package com.antigate.requests;

import com.antigate.client.AntigateClient;
import com.antigate.config.AntigateConfig;
import com.antigate.config.consts.AntigateConstants;
import com.antigate.execption.AntigateException;
import com.antigate.execption.ErrorCode;
import com.antigate.parser.AntigateParser;
import com.antigate.response.AntigateCaptchaStatus;
import com.antigate.responses.GetCaptchaStatusResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * @author itsimoshka
 */
public class GetCaptchaStatusRequest implements Request<GetCaptchaStatusResponse>{
    private final String captchaID;
    private final AntigateConfig config;
    public GetCaptchaStatusRequest(final String captchaID, final AntigateConfig config) {
        this.captchaID = captchaID;
        this.config = config;
    }
    @Override
    public GetCaptchaStatusResponse execute() throws AntigateException {
        URI getStatusUri = null;

        try {
            getStatusUri = new URI(AntigateConstants.GET_CAPTCHA_STATUS_URL + getCaptchaStatusURIParameters(captchaID));
        } catch (URISyntaxException e) {
            throw new AntigateException(ErrorCode.UNKNOWN_EXCEPTION);
        }

        HttpGet get = new HttpGet(getStatusUri);

        HttpResponse response;
        String captchaResult;
        try {
            response = AntigateClient.execute(get);
            captchaResult = AntigateParser.parseGetStatusResponse(response.getEntity());

        } catch (IOException e) {
            throw new AntigateException(ErrorCode.UNKNOWN_EXCEPTION);
        }

        GetCaptchaStatusResponse statusResponse;
        if (captchaResult != null) {
            statusResponse = new GetCaptchaStatusResponse(captchaResult, AntigateCaptchaStatus.OK);
        } else {
            statusResponse = new GetCaptchaStatusResponse(null, AntigateCaptchaStatus.CAPCHA_NOT_READY);
        }

        return statusResponse;
    }

    private String getCaptchaStatusURIParameters(final String captchaID) {
        return "?key=" + config.getKey() + "&action=get&id=" + captchaID;
    }
}
