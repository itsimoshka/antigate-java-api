package com.antigate.parser;

import com.antigate.config.consts.AntigateConstants;
import com.antigate.execption.AntigateException;
import com.antigate.execption.ErrorCode;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author igor.timoshko
 */
public class AntigateParser {

    public static String parseCaptchaKey(HttpEntity httpEntity) throws IOException, AntigateException {


            String response = EntityUtils.toString(httpEntity, "UTF-8");
        System.out.println(response);

        if (response != null) {
            if (response.startsWith(AntigateConstants.OK_PREFIX)) {
                return response.substring(AntigateConstants.OK_PREFIX.length(), response.length() - 1);
            } else {
                ErrorCode errorCode = ErrorCode.valueOf(response);
                try {
                    throw new AntigateException(errorCode);
                } catch (IllegalArgumentException e) {
                    throw new AntigateException(ErrorCode.UNKNOWN_EXCEPTION);
                }
            }
        } else {
            throw new AntigateException(ErrorCode.UNKNOWN_EXCEPTION);
        }

    }
}
