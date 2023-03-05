package edu.sabanciuniv.yeneryumluhw4.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
