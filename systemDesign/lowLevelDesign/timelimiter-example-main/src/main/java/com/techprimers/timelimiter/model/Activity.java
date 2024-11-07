package com.techprimers.timelimiter.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Activity {

    private String activity;
    private String type;
    private String participants;
    private String price;
    private String link;
    private String key;
    private String accessibility;
}
