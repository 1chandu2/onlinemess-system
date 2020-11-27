package com.chandu.onlinemess.security.jwt.impl;

import com.chandu.onlinemess.security.jwt.TokenVerifier;
import org.springframework.stereotype.Component;

@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
