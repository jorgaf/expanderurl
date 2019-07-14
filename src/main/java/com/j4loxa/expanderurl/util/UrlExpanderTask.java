package com.j4loxa.expanderurl.util;

import com.j4loxa.expanderurl.model.SEUrl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.concurrent.Callable;

public class UrlExpanderTask implements Callable<SEUrl> {
    private HttpClient client;
    private String shortUrl;

    public UrlExpanderTask(String shortUrl, HttpClient client) {
        this.shortUrl = shortUrl;
        this.client = client;
    }

    @Override
    public SEUrl call() throws Exception {
        var request = HttpRequest.newBuilder().
                uri(URI.create(shortUrl)).
                timeout(Duration.ofSeconds(10)).
                method("HEAD", HttpRequest.BodyPublishers.noBody()).
                build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200) {
                return new SEUrl(shortUrl,
                        response.uri().toASCIIString(),
                        response.statusCode(),
                        response.headers().firstValue("content-type").orElse(""));
            } else {
                return new SEUrl(shortUrl,
                        null,
                        response.statusCode(),
                        null);
            }
        }catch (HttpTimeoutException httpe) {
            return new SEUrl(shortUrl,
                    null,
                    0,
                    null);
        }
    }
}
