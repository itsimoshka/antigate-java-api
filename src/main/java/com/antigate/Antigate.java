package com.antigate;

import com.antigate.config.AntigateConfig;
import com.antigate.config.consts.AntigateConstants;
import com.antigate.execption.AntigateException;
import com.antigate.parser.AntigateParser;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/**
 * @author itsimoshka
 */
public class Antigate {
    private static AntigateConfig config;
    /**
     * Method send captcha file to Antigate.com
     *
     * @param filePath path to file
     * @return captcha key from Antigate.com
     * @throws IOException exception with file
     * @throws AntigateException wrapper exception
     */
    public static String sendFile(final String filePath) throws IOException, AntigateException {

        MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );
        prepareEntity(entity);

        File file = new File(filePath);
        entity.addPart( "file", new FileBody(( file ), "application/zip" ));

        HttpPost post = new HttpPost(AntigateConstants.SEND_FILE_CAPTCHA_URL);
        post.setEntity( entity );

        HttpClient client = createClient();
        String captchaID = AntigateParser.parseSendFileResponse(client.execute(post).getEntity());

        shutdownConnection(client);

        return captchaID;
    }

    private static void getCaptchaStatus(final String captchaID) throws IOException, URISyntaxException {
        URI getStatusUri = null;

        getStatusUri = new URI(getStatusParameters(captchaID));


        HttpClient client = createClient();

        HttpGet get = new HttpGet(getStatusUri);

        client.execute(get);

    }
    private static String getStatusParameters(final String captchaID) {
        return "key=" + config.getKey() + "&action=get&id=" + captchaID;
    }
    private static void shutdownConnection(final HttpClient client) {
        client.getConnectionManager().shutdown();
    }

    private static void prepareEntity(final MultipartEntity entity) {

        try {
            entity.addPart( "key", new StringBody(AntigateConfig.getKey(), "text/plain",//TODO config exception
                    Charset.forName("UTF-8")));
            entity.addPart( "method", new StringBody( "post" , "text/plain",
                    Charset.forName("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private static HttpClient createClient() {
        HttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        return client;
    }

}
