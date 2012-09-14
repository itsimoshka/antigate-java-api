package com.antigate.requests;

import com.antigate.client.AntigateClient;
import com.antigate.config.AntigateConfig;
import com.antigate.config.consts.AntigateConstants;
import com.antigate.execption.AntigateException;
import com.antigate.execption.ErrorCode;
import com.antigate.parser.AntigateParser;
import com.antigate.responses.SendFileResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author itsimoshka
 */
public class SendFileRequest implements Request<SendFileResponse> {
    private final AntigateConfig config;
    private final String filePath;

    public SendFileRequest(final AntigateConfig config, final String filePath) {
        this.config = config;
        this.filePath = filePath;
    }

    @Override
    public SendFileResponse execute() throws AntigateException {

        MultipartEntity entity = createMultipartEntity();

        File file = new File(filePath);
        entity.addPart( "file", new FileBody(( file ), "application/zip" ));

        HttpPost post = new HttpPost(AntigateConstants.SEND_FILE_CAPTCHA_URL);
        post.setEntity( entity );

        String captchaID;
        try {
            captchaID = AntigateParser.parseSendFileResponse(AntigateClient.execute(post).getEntity());
        } catch (IOException e) {
            throw new AntigateException(ErrorCode.UNKNOWN_EXCEPTION);
        }

        SendFileResponse response = new SendFileResponse(captchaID);
        return response;
    }

    private MultipartEntity createMultipartEntity() throws AntigateException {
        MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );

        try {
            addPartToEntity(entity, "key",config.getKey());
            addPartToEntity(entity, "method", "post");

            if (config.isTwoWords()){
                addPartToEntity(entity, "phrase", "1");
            } else {
                addPartToEntity(entity, "phrase", "0");
            }
            if (config.isRegisterSensitive()) {
                addPartToEntity(entity, "regsense", "1");
            } else {
                addPartToEntity(entity, "regsense", "0");
            }

            addPartToEntity(entity, "numeric", config.getNumeric().getNumericCode());

            if (config.isMathExpression()) {
                addPartToEntity(entity, "calc", "1");
            } else {
                addPartToEntity(entity, "calc", "0");
            }

            addPartToEntity(entity, "min_len",String.valueOf(config.getMinLength()));
            addPartToEntity(entity, "max_len",String.valueOf(config.getMaxLength()));
            if (config.isRussian()) {
                addPartToEntity(entity, "is_russian", "1");
            } else {
                addPartToEntity(entity, "is_russian", "0");
            }
            addPartToEntity(entity, "max_bid", String.valueOf(config.getPriceOfThousands()));
        } catch (UnsupportedEncodingException e) {
            throw new AntigateException(ErrorCode.UNKNOWN_EXCEPTION);
        }

        return entity;
    }

    private void addPartToEntity(final MultipartEntity entity, final String name, final String value) throws UnsupportedEncodingException {
        entity.addPart(name, new StringBody(value,Charset.forName("UTF-8")));
    }
}
