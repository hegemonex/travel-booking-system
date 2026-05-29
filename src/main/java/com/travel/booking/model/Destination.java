package com.travel.booking.model;

import java.time.LocalDateTime;

public class Destination {

    private Long id;
    private String country;
    private String city;
    private String description;
    private boolean visaRequired;
    private LocalDateTime createdAt;

    public Destination() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isVisaRequired() { return visaRequired; }
    public void setVisaRequired(boolean visaRequired) { this.visaRequired = visaRequired; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }


    public static class Builder {

        private final Destination destination = new Destination();

        public Builder id(Long id) {
            destination.id = id;
            return this;
        }

        public Builder country(String country) {
            destination.country = country;
            return this;
        }

        public Builder city(String city) {
            destination.city = city;
            return this;
        }

        public Builder description(String description) {
            destination.description = description;
            return this;
        }

        public Builder visaRequired(boolean visaRequired) {
            destination.visaRequired = visaRequired;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            destination.createdAt = createdAt;
            return this;
        }

        public Destination build() {
            return destination;
        }
    }
}