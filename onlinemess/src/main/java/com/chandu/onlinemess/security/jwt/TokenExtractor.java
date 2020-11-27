package com.chandu.onlinemess.security.jwt;

public interface TokenExtractor {
    public String extract(String payload);
}
