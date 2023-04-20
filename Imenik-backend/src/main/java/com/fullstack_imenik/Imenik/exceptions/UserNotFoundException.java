package com.fullstack_imenik.Imenik.exceptions;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(Long id){
        super("Cannot find the user with the id " + id + " :(");
    }

}
