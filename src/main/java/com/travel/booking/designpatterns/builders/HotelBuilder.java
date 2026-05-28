package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Hotel;
import com.travel.booking.model.Trip;

import java.time.LocalDateTime;

public class HotelBuilder {

    private final Hotel hotel =  new Hotel();

    public HotelBuilder id(Long id) {
        hotel.setId(id);
        return this;
    }

    public HotelBuilder name(String name) {
        hotel.setName(name);
        return this;
    }

    public HotelBuilder city(String city) {
        hotel.setCity(city);
        return this;
    }

    public HotelBuilder address(String address) {
        hotel.setAddress(address);
        return this;
    }

    public HotelBuilder trip(Trip trip) {
        hotel.setTrip(trip);
        return this;
    }

    public HotelBuilder starRating(int starRating) {
        hotel.setStarRating(starRating);
        return this;
    }

    public HotelBuilder breakfastIncluded(boolean breakfastIncluded) {
        hotel.setBreakfastIncluded(breakfastIncluded);
        return this;
    }

    public HotelBuilder pricePerNight(double pricePerNight) {
        hotel.setPricePerNight(pricePerNight);
        return this;
    }

    public HotelBuilder createdAt(LocalDateTime createdAt) {
        hotel.setCreatedAt(createdAt);
        return this;
    }

    public Hotel build() {
        return hotel;
    }
}

