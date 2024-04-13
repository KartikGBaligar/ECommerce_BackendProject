package com.kartik.ecommerce_fakestore;

public class InvalidTokenException extends RuntimeException
{
    public InvalidTokenException(String message) {
        super(message);
    }
}
