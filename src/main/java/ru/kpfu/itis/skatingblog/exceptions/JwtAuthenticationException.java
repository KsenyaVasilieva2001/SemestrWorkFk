package ru.kpfu.itis.skatingblog.exceptions;

import io.jsonwebtoken.Jwt;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.naming.AuthenticationException;

@Getter
public class JwtAuthenticationException extends AuthenticationException {
    private HttpStatus httpStatus;
    public JwtAuthenticationException(String message){
        super(message);
    }

    public JwtAuthenticationException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
