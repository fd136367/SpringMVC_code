package com.lenovo.exception;

//当用户的姓名有异常，抛出NameException
public class NameException extends MyUserException{
    public NameException() {

    }

    public NameException(String message) {
        super(message);
    }
}
