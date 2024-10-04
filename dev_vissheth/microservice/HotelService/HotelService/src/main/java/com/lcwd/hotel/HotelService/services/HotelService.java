package com.lcwd.hotel.HotelService.services;

import com.lcwd.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    // create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAll();

    //getsingle hotel
    Hotel get(String id);

}
