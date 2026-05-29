package com.travel.booking.model;

import java.time.LocalDateTime;

public class Transport {

    private Long id;
    private String type;
    private int capacity;
    private boolean available;
    private double transportPrice;
    private LocalDateTime createdAt;

    public Transport() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public double getTransportPrice() { return transportPrice; }
    public void setTransportPrice(double transportPrice) { this.transportPrice = transportPrice; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static class Builder {

        private final Transport transport = new Transport();

        public Builder id(Long id) {
            transport.id = id;
            return this;
        }

        public Builder type(String type) {
            transport.type = type;
            return this;
        }

        public Builder capacity(int capacity) {
            transport.capacity = capacity;
            return this;
        }

        public Builder available(boolean available) {
            transport.available = available;
            return this;
        }

        public Builder transportPrice(double transportPrice) {
            transport.transportPrice = transportPrice;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            transport.createdAt = createdAt;
            return this;
        }

        public Transport build() {
            return transport;
        }
    }
}