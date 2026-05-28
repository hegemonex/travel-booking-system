package com.travel.booking.designpatterns.builders;

import com.travel.booking.model.Transport;

import java.time.LocalDateTime;

public class TransportBuilder {

    private final Transport transport = new Transport();

    public TransportBuilder id(Long id) {
        transport.setId(id);
        return this;
    }

    public TransportBuilder type(String type) {
        transport.setType(type);
        return this;
    }

    public TransportBuilder capacity(int capacity) {
        transport.setCapacity(capacity);
        return this;
    }

    public TransportBuilder available(boolean available) {
        transport.setAvailable(available);
        return this;
    }

    public TransportBuilder transportPrice(double transportPrice) {
        transport.setTransportPrice(transportPrice);
        return this;
    }

    public TransportBuilder createdAt(LocalDateTime createdAt) {
        transport.setCreatedAt(createdAt);
        return this;
    }

    public Transport build() {
        return transport;
    }
}
