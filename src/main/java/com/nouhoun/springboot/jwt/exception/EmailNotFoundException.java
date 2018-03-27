package com.nouhoun.springboot.jwt.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author: kameshr
 */
public class EmailNotFoundException extends AuthenticationException {
    public EmailNotFoundException(String message) {
        super(message);
    }
}
