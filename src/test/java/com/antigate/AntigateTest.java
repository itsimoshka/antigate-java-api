package com.antigate;


import com.antigate.config.AntigateConfig;
import com.antigate.config.DefaultAntigateConfig;
import com.antigate.exception.AntigateException;
import com.antigate.response.AntigateCaptchaStatus;
import com.antigate.responses.GetCaptchaStatusResponse;
import com.antigate.responses.SendFileResponse;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

/**
 * @author itsimoshka
 */
public class AntigateTest {

    @Test
    public void sendFileTest() {
        try {
            long startTime = System.currentTimeMillis();

            AntigateConfig config = new DefaultAntigateConfig();
            config.setKey("");//insert your code here
            AntigateFacade antigate = new AntigateFacade(config);
//            SendFileResponse sendFileResponse = antigate.sendFile("1.png");//insert your captcha file path here
            SendFileResponse sendFileResponse = antigate.sendFile(new URL(""));//insert your captcha file url here
            String captchaID = sendFileResponse.getCaptchaID();

            int attempts = 1;
            while (true) {
                Thread.sleep(5000);
                System.out.println("Attempt number " + attempts++);
                GetCaptchaStatusResponse getCaptchaStatusResponse = antigate.getCaptchaStatus(captchaID);

                if (getCaptchaStatusResponse.getCaptchaStatus().equals(AntigateCaptchaStatus.OK)) {
                    System.out.println(getCaptchaStatusResponse.getCaptchaWord());
                    break;
                }

            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Execution time: " + elapsedTime/1000 + " seconds");

        } catch (AntigateException e) {
            System.out.println(e.getErrorCode());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
