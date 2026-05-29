package com.travel.booking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {

    private Long id;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private boolean directFlight;
    private double ticketPrice;
    private LocalDateTime createdAt;

    public Flight() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }

    public String getDepartureAirport() { return departureAirport; }
    public void setDepartureAirport(String departureAirport) { this.departureAirport = departureAirport; }

    public String getArrivalAirport() { return arrivalAirport; }
    public void setArrivalAirport(String arrivalAirport) { this.arrivalAirport = arrivalAirport; }

    public LocalDate getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }

    public LocalDate getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(LocalDate arrivalDate) { this.arrivalDate = arrivalDate; }

    public boolean isDirectFlight() { return directFlight; }
    public void setDirectFlight(boolean directFlight) { this.directFlight = directFlight; }

    public double getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static class Builder {

        private final Flight flight = new Flight();

        public Builder id(Long id) {
            flight.id = id;
            return this;
        }

        public Builder airline(String airline) {
            flight.airline = airline;
            return this;
        }

        public Builder departureAirport(String departureAirport) {
            flight.departureAirport = departureAirport;
            return this;
        }

        public Builder arrivalAirport(String arrivalAirport) {
            flight.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder departureDate(LocalDate departureDate) {
            flight.departureDate = departureDate;
            return this;
        }

        public Builder arrivalDate(LocalDate arrivalDate) {
            flight.arrivalDate = arrivalDate;
            return this;
        }

        public Builder directFlight(boolean directFlight) {
            flight.directFlight = directFlight;
            return this;
        }

        public Builder ticketPrice(double ticketPrice) {
            flight.ticketPrice = ticketPrice;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            flight.createdAt = createdAt;
            return this;
        }

        public Flight build() {
            return flight;
        }
    }
}