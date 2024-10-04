package com.lcwd.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String ratingId;
    private String userID;
    private String hotelId;
    private int rating;
    private String remark;
    private String feedback;
}
