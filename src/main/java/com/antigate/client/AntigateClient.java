package com.antigate.client;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;

import java.io.IOException;

/**
 * @author itsimoshka
 */
public class AntigateClient {
    private static HttpClient client;

    private static HttpClient getClient() {
        if (client == null) {
            client = new DefaultHttpClient();
            client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        }
        return client;
    }

    public static HttpResponse execute(final HttpUriRequest request) throws IOException {
        return getClient().execute(request);
    }

    public static void shutDownConnection() {
        getClient().getConnectionManager().shutdown();
    }
}
