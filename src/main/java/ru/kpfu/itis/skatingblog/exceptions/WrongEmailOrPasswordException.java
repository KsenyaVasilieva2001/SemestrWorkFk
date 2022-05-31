package ru.kpfu.itis.skatingblog.exceptions;

public class WrongEmailOrPasswordException extends RuntimeException{
    public WrongEmailOrPasswordException() {
    }

    public WrongEmailOrPasswordException(String message) {
        super(message);
    }

    public WrongEmailOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongEmailOrPasswordException(Throwable cause) {
        super(cause);
    }
}
