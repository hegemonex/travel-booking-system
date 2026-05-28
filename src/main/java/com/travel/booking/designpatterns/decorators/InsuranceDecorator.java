package com.travel.booking.designpatterns.decorators;

import com.travel.booking.designpatterns.decorators.interfaces.TripComponent;

public class InsuranceDecorator implements TripComponent {
    private TripComponent trip;

    public InsuranceDecorator(TripComponent trip) {
        this.trip = trip;
    }

    @Override
    public double getCost() {
        return trip.getCost() + 100;
    }
}
