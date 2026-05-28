package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Booking;
import com.travel.booking.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightBuilder {
    private final Flight flight = new Flight();

    public FlightBuilder id(Long id) {
        flight.setId(id);
        return this;
    }

    public FlightBuilder airline(String airline) {
        flight.setAirline(airline);
        return this;
    }

    public FlightBuilder departureAirport(String departureAirport) {
        flight.setDepartureAirport(departureAirport);
        return this;
    }

    public FlightBuilder arrivalAirport(String arrivalAirport) {
        flight.setArrivalAirport(arrivalAirport);
        return this;
    }

    public FlightBuilder departureTime(LocalDate departureTime) {
        flight.setDepartureDate(departureTime);
        return this;
    }

    public FlightBuilder arrivalTime(LocalDate arrivalTime) {
        flight.setArrivalDate(arrivalTime);
        return this;
    }

    public FlightBuilder directFlight(boolean directFlight) {
        flight.setDirectFlight(directFlight);
        return this;
    }

    public FlightBuilder ticketPrice(double ticketPrice) {
        flight.setTicketPrice(ticketPrice);
        return this;
    }

    public FlightBuilder createdAt(LocalDateTime createdAt) {
        flight.setCreatedAt(createdAt);
        return this;
    }

    public Flight build() {
        return flight;
    }
}
