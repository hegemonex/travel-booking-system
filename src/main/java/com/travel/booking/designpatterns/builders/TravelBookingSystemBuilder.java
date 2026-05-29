package com.travel.booking.designpatterns.builders;


import com.travel.booking.model.TravelBookingSystem;
import com.travel.booking.model.TravelPackage;
import com.travel.booking.model.Trip;
import com.travel.booking.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class TravelBookingSystemBuilder {

    private final TravelBookingSystem travelBookingSystem =  new TravelBookingSystem();

    public TravelBookingSystemBuilder id(Long id){
        travelBookingSystem.setId(id);
        return this;
    }

    public TravelBookingSystemBuilder systemName(String systemName){
        travelBookingSystem.setSystemName(systemName);
        return this;
    }

    public TravelBookingSystemBuilder createdAt(LocalDateTime createdAt){
        travelBookingSystem.setCreatedAt(createdAt);
        return this;
    }

    public TravelBookingSystemBuilder users(List<User> users){
        travelBookingSystem.setUsers(users);
        return this;
    }

    public TravelBookingSystemBuilder trip(List<Trip> trips){
        travelBookingSystem.setTrips(trips);
        return this;
    }

    public TravelBookingSystemBuilder packages(List<TravelPackage>  packages){
        travelBookingSystem.setPackages(packages);
        return this;
    }

    public TravelBookingSystem build(){
        return travelBookingSystem;
    }
}
