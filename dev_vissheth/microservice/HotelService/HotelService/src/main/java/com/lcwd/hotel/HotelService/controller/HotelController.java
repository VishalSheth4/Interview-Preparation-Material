package com.lcwd.hotel.HotelService.controller;

import com.lcwd.hotel.HotelService.entities.Hotel;
import com.lcwd.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {


    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        String randomId  = String.valueOf(UUID.randomUUID());
        hotel.setId(randomId);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }


    @GetMapping("/hotelId")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String  hotelId){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));

    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
