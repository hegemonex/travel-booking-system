package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Booking;
import com.travel.booking.model.Destination;

import java.time.LocalDateTime;

public class DestinationBuilder {

    private final Destination destination =  new Destination();

    public DestinationBuilder id(Long id) {
        destination.setId(id);
        return this;
    }

    public DestinationBuilder country(String country) {
        destination.setCountry(country);
        return this;
    }

    public DestinationBuilder city(String city) {
        destination.setCity(city);
        return this;
    }

    public DestinationBuilder description(String description) {
        destination.setDescription(description);
        return this;
    }

    public DestinationBuilder visaRequired(boolean visaRequired) {
        destination.setVisaRequired(visaRequired);
        return this;
    }

    public DestinationBuilder createdAt(LocalDateTime createdAt) {
        destination.setCreatedAt(createdAt);
        return this;
    }

    public Destination build() {
        return destination;
    }
}
