package com.solvd.tests;

import com.travel.booking.model.*;
import com.travel.booking.service.interfaces.TripService;
import com.travel.booking.service.impl.TripServiceImpl;
import com.travel.booking.service.interfaces.FlightService;
import com.travel.booking.service.impl.FlightServiceImpl;
import com.travel.booking.service.interfaces.TransportService;
import com.travel.booking.service.impl.TransportServiceImpl;
import com.travel.booking.service.interfaces.TravelPackageService;
import com.travel.booking.service.impl.TravelPackageServiceImpl;
import com.travel.booking.service.interfaces.TravelBookingSystemService;
import com.travel.booking.service.impl.TravelBookingSystemServiceImpl;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TripTests {

    private TripService tripService;
    private FlightService flightService;
    private TransportService transportService;
    private TravelPackageService packageService;
    private TravelBookingSystemService tbsService;

    @BeforeClass
    public void setup() {
        tripService = new TripServiceImpl();
        flightService = new FlightServiceImpl();
        transportService = new TransportServiceImpl();
        packageService = new TravelPackageServiceImpl();
        tbsService = new TravelBookingSystemServiceImpl();
    }

    private Trip createTrip() {

        TravelBookingSystem tbs = new TravelBookingSystem();
        tbs.setSystemName("Test System");
        tbs.setCreatedAt(LocalDateTime.now());
        tbsService.save(tbs);

        Flight flight = new Flight();
        flight.setAirline("Test Airline");
        flight.setDepartureAirport("TBS");
        flight.setArrivalAirport("LHR");
        flight.setDepartureDate(LocalDate.now());
        flight.setArrivalDate(LocalDate.now());
        flight.setDirectFlight(true);
        flight.setTicketPrice(500);
        flight.setCreatedAt(LocalDateTime.now());
        flightService.save(flight);

        Transport transport = new Transport();
        transport.setType("Bus");
        transport.setCapacity(50);
        transport.setAvailable(true);
        transport.setTransportPrice(100);
        transport.setCreatedAt(LocalDateTime.now());
        transportService.save(transport);

        TravelPackage pack = new TravelPackage();
        pack.setName("London Package");
        pack.setDescription("Test package");
        pack.setPackagePrice(1500);
        pack.setActive(true);
        pack.setStartDate(LocalDate.now());
        pack.setEndDate(LocalDate.now().plusDays(5));
        pack.setCreatedAt(LocalDateTime.now());
        pack.setTravelBookingSystem(tbs);
        packageService.save(pack);

        Trip trip = new Trip();
        trip.setTitle("London Trip");
        trip.setDescription("5 day trip");
        trip.setPrice(999);
        trip.setAvailabe(true);
        trip.setDepartureDate(LocalDate.now());
        trip.setReturnDate(LocalDate.now().plusDays(5));
        trip.setCreatedAt(LocalDate.now());

        trip.setFlight(flight);
        trip.setTransport(transport);
        trip.setTravelPackage(pack);
        trip.setTravelBookingSystem(tbs);

        tripService.save(trip);

        return trip;
    }

    @Test
    public void saveTripTest() {
        Trip trip = createTrip();

        Assert.assertNotNull(trip.getId(),
                "Trip should be saved and have an ID.");
    }

    @Test
    public void findTripByIdTest() {
        Trip trip = createTrip();

        Trip found = tripService.findById(trip.getId());

        Assert.assertNotNull(found,
                "Trip should be found by ID.");
    }

    @Test
    public void findAllTripsTest() {
        List<Trip> trips = tripService.findAll();

        Assert.assertNotNull(trips,
                "Trip list should not be null.");
    }

    @Test
    public void updateTripTest() {
        Trip trip = createTrip();

        trip.setTitle("Updated Trip");
        tripService.update(trip);

        Trip updated = tripService.findById(trip.getId());

        Assert.assertEquals(updated.getTitle(),
                "Updated Trip",
                "Trip title should be updated.");
    }

    @Test
    public void deleteTripTest() {
        Trip trip = createTrip();

        tripService.delete(trip.getId());

        Trip deleted = tripService.findById(trip.getId());

        Assert.assertNull(deleted,
                "Deleted trip should not exist.");
    }
}