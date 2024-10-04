package com.lcwd.rating.service;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating createRating(Rating rating);

    //getall Rating
    List<Rating> getAllRating();

    // get rating by userID
    List<Rating> getRatingByUserId(String userId);

    // get rating by hotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
