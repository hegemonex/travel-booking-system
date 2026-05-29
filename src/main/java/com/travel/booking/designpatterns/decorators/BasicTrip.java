package com.travel.booking.designpatterns.decorators;

import com.travel.booking.designpatterns.decorators.interfaces.TripComponent;

public class BasicTrip implements TripComponent {
    private double price;

    public BasicTrip(double price) {
        this.price = price;
    }

    @Override
    public double getCost() {
        return price;
    }
}
