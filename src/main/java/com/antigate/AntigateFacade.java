package com.antigate;

import com.antigate.config.AntigateConfig;
import com.antigate.exception.AntigateException;
import com.antigate.requests.GetCaptchaStatusRequest;
import com.antigate.requests.SendFileRequest;
import com.antigate.responses.GetCaptchaStatusResponse;
import com.antigate.responses.SendFileResponse;

import java.io.IOException;
import java.net.URL;

/**
 * @author itsimoshka
 */
public class AntigateFacade {
    private final AntigateConfig config;

    public AntigateFacade(final AntigateConfig config) {
        this.config = config;
    }
    /**
     * Method send captcha file to AntigateFacade.com
     *
     * @param filePath path to file
     * @return captcha key from AntigateFacade.com
     * @throws IOException exception with file
     * @throws AntigateException wrapper exception
     */
    public SendFileResponse sendFile(final String filePath) throws AntigateException, IOException {

        SendFileRequest request = new SendFileRequest(config, filePath);
        return request.execute();

    }

    /**
     * Method send captcha file to AntigateFacade.com
     *
     * @param fileUrl url to file
     * @return captcha key from AntigateFacade.com
     * @throws IOException exception with file
     * @throws AntigateException wrapper exception
     */
    public SendFileResponse sendFile(final URL fileUrl) throws AntigateException, IOException {

        SendFileRequest request = new SendFileRequest(config, fileUrl);
        return request.execute();

    }

    public GetCaptchaStatusResponse getCaptchaStatus(final String captchaID) throws AntigateException {
        GetCaptchaStatusRequest request = new GetCaptchaStatusRequest(captchaID, config);
        return request.execute();
    }

    public AntigateConfig getConfig() {
        return config;
    }

}
