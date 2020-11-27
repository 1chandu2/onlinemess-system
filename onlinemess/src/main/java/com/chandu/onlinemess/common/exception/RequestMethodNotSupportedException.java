package com.chandu.onlinemess.common.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

public class RequestMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 32342352342354326L;

    public RequestMethodNotSupportedException(String msg) {
        super(msg);
    }
}
