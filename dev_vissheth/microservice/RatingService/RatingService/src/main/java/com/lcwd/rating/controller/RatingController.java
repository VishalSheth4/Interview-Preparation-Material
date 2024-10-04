package com.lcwd.rating.controller;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.service.RatingService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    //create Rating
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    //get all
    public ResponseEntity<List<Rating>> getRatings(){
        return  ResponseEntity.ok(ratingService.getAllRating());
    }

    //get all
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String HotelId){
        return  ResponseEntity.ok(ratingService.getRatingByHotelId(HotelId));
    }

    @GetMapping("/hotels/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String UserId){
        return  ResponseEntity.ok(ratingService.getRatingByUserId(UserId));
    }

}
