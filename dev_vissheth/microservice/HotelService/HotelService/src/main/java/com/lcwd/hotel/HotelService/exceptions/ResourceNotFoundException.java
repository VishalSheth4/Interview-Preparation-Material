package com.lcwd.hotel.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not found exceptions");
    }

    public void ResourceNotFoundExceptionCustom(String msg){
        System.out.println("Error : "+ msg);
    }
}
