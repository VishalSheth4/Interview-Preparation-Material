package com.lcwd.user.service.execptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource Not Found on server");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
