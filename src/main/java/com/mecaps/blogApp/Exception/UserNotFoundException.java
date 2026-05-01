package com.mecaps.blogApp.Exception;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException (String message) {
        super(message);
    }
}
