package com.antigate.parser;

import com.antigate.config.consts.AntigateConstants;
import com.antigate.exception.AntigateException;
import com.antigate.exception.ErrorCode;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author itsimoshka
 */
public class AntigateParser {

    public static String parseSendFileResponse(HttpEntity response) throws IOException, AntigateException {

        String responseText = EntityUtils.toString(response, "UTF-8");

        if (responseText != null) {
            if (responseText.startsWith(AntigateConstants.OK_PREFIX)) {
                return responseText.substring(AntigateConstants.OK_PREFIX.length(), responseText.length());
            } else {
                ErrorCode errorCode = ErrorCode.valueOf(responseText);
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
    public static String parseGetStatusResponse(HttpEntity response) throws IOException, AntigateException {

        String responseText = EntityUtils.toString(response, "UTF-8");

        if (responseText != null) {
            if (responseText.startsWith(AntigateConstants.OK_PREFIX)) {
                return responseText.substring(AntigateConstants.OK_PREFIX.length(), responseText.length());
            } else {
                return null;
            }
        } else {
            throw new AntigateException(ErrorCode.UNKNOWN_EXCEPTION);
        }

    }
}
