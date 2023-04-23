package com.app.Exception;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message){
        super(message);
    }
}
