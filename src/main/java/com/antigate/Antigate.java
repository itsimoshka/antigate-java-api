package com.antigate;

import com.antigate.config.AntigateConfig;
import com.antigate.config.consts.AntigateConstants;
import com.antigate.execption.AntigateException;
import com.antigate.parser.AntigateParser;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author itsimoshka
 */
public class Antigate {

    public static String sendFile(final String filePath) throws IOException, AntigateException {

        HttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

        HttpPost post   = new HttpPost(AntigateConstants.SEND_CAPTCHA_URL);
        MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );

        File file = new File(filePath);
        entity.addPart( "file", new FileBody(( file ), "application/zip" ));

        try {
            entity.addPart( "key", new StringBody(AntigateConfig.getKey(), "text/plain",//TODO config exception
                    Charset.forName("UTF-8")));
            entity.addPart( "method", new StringBody( "post" , "text/plain",
                    Charset.forName("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        post.setEntity( entity );

        String captchaKey = AntigateParser.parseResponse(client.execute(post).getEntity());

        client.getConnectionManager().shutdown();

        return captchaKey;
    }
}
