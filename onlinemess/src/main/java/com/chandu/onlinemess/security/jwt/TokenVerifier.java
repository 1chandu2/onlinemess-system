package com.chandu.onlinemess.security.jwt;

public interface TokenVerifier {
    public boolean verify(String jti);
}
