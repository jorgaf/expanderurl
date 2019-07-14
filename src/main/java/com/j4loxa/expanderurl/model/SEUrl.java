package com.j4loxa.expanderurl.model;

import java.util.Optional;

public class SEUrl {

    private Optional<String> longUrl;
    private String shortUrl;
    private int statusCode;
    private Optional<String> mimeType;

    public SEUrl() {
    }

    public SEUrl(String shortUrl, String longUrl, int statusCode, String mimeType) {
        setLongUrl(longUrl);
        this.shortUrl = shortUrl;
        this.statusCode = statusCode;
        setMimeType(mimeType);
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Optional<String> getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = Optional.ofNullable(longUrl);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Optional<String> getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = Optional.ofNullable(mimeType);
    }
}
