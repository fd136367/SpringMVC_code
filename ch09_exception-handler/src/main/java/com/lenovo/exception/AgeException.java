package com.lenovo.exception;

//当用户的年龄有异常，抛出异常
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
