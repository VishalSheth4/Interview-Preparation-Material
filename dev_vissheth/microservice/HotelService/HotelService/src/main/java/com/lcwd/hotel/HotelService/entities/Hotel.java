package com.lcwd.hotel.HotelService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="hotels")
public class Hotel {

    @Id
    private String id;

    @Column(name="NAME")
    private String name;

    @Column(name="LOCATION")
    private String location;

    @Column(name="ABOUT")
    private String about;
}
