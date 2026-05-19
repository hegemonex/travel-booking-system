import com.travel.booking.model.*;
import com.travel.booking.service.impl.*;
import com.travel.booking.service.interfaces.*;
import com.travel.booking.util.ConnectionPool;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = ConnectionPool.getConnection()) {
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }

        TravelBookingSystemService travelBookingSystemService = new TravelBookingSystemServiceImpl();
        TransportService transportService = new TransportServiceImpl();
        TravelPackageService travelPackageService = new TravelPackageServiceImpl();
        FlightService flightService = new FlightServiceImpl();
        UserService userService = new UserServiceImpl();
        DestinationService destinationService = new DestinationServiceImpl();
        TripService tripService = new TripServiceImpl();
        ReviewService reviewService = new ReviewServiceImpl();
        BookingService bookingService = new BookingServiceImpl();

        TravelBookingSystem tbs = new TravelBookingSystem();
        tbs.setId(1L);
        tbs.setSystemName("Main Booking System");
        tbs.setCreatedAt(LocalDateTime.now());
        travelBookingSystemService.save(tbs);
        System.out.println("TravelBookingSystem saved");

        Transport transport = new Transport();
        transport.setId(1L);
        transport.setType("Bus");
        transport.setCapacity(50);
        transport.setAvailable(true);
        transport.setTransportPrice(49.99);
        transport.setCreatedAt(LocalDateTime.now());
        transportService.save(transport);
        System.out.println("Transport saved");

        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setId(1L);
        travelPackage.setName("London Package");
        travelPackage.setDescription("All inclusive");
        travelPackage.setPackagePrice(1299.99);
        travelPackage.setActive(true);
        travelPackage.setStartDate(LocalDate.of(2025, 6, 1));
        travelPackage.setEndDate(LocalDate.of(2025, 6, 6));
        travelPackage.setCreatedAt(LocalDateTime.now());
        travelPackage.setTravelBookingSystem(tbs);
        travelPackageService.save(travelPackage);
        System.out.println("TravelPackage saved");

        Flight flight = new Flight();
        flight.setId(1L);
        flight.setAirline("Georgian Airways");
        flight.setDepartureAirport("TBS");
        flight.setArrivalAirport("LHR");
        flight.setDepartureDate(LocalDate.of(2025, 6, 1));
        flight.setArrivalDate(LocalDate.of(2025, 6, 1));
        flight.setDirectFlight(true);
        flight.setTicketPrice(299.99);
        flight.setCreatedAt(LocalDateTime.now());
        flightService.save(flight);
        System.out.println("Flight saved");

        User user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@gmail.com");
        user.setPhoneNumber("555-1234");
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setCreatedAt(LocalDateTime.now());
        user.setTravelBookingSystem(tbs);
        userService.save(user);
        System.out.println("User saved");

        Destination destination = new Destination();
        destination.setId(1L);
        destination.setCountry("United Kingdom");
        destination.setCity("London");
        destination.setDescription("Capital of UK");
        destination.setVisaRequired(false);
        destination.setCreatedAt(LocalDateTime.now());
        destinationService.save(destination);
        System.out.println("Destination saved");

        Trip trip = new Trip();
        trip.setTitle("London Adventure");
        trip.setDescription("5 days in London");
        trip.setPrice(999.99);
        trip.setAvailabe(true);
        trip.setDepartureDate(LocalDate.of(2025, 6, 1));
        trip.setReturnDate(LocalDate.of(2025, 6, 6));
        trip.setCreatedAt(LocalDate.now());
        trip.setFlight(flight);
        trip.setTransport(transport);
        trip.setTravelPackage(travelPackage);
        trip.setTravelBookingSystem(tbs);
        tripService.save(trip);
        System.out.println("Trip saved");

        Review review = new Review();
        review.setId(1L);
        review.setUser(user);
        review.setTrip(trip);
        review.setRating(5);
        review.setComment("Amazing trip!");
        review.setRecommended(true);
        review.setReviewDate(LocalDate.now());
        review.setCreatedAt(LocalDateTime.now());
        reviewService.save(review);
        System.out.println("Review saved");

        Payment payment = new Payment();
        payment.setId(1L);
        payment.setPaymentMethod("Credit Card");
        payment.setAmount(999.99);
        payment.setSuccessful(true);
        payment.setPaymentDate(LocalDate.now());
        payment.setCreatedAt(LocalDateTime.now());
        // paymentService.save(payment); // add this once you have PaymentService

        Booking booking = new Booking();
        booking.setId(1L);
        booking.setUser(user);
        booking.setTrip(trip);
        booking.setPayment(payment);
        booking.setTotalPrice(999.99);
        booking.setConfirmed(true);
        booking.setBookingDate(LocalDate.now());
        booking.setCreatedAt(LocalDateTime.now());
        // bookingService.save(booking); // uncomment once PaymentService is ready

        Hotel hotel = new Hotel();
        hotel.setName("Hilton");
        hotel.setCity("Tbilisi");
        hotel.setAddress("Rustaveli Ave");
        hotel.setStarRating(5);
        hotel.setBreakfastIncluded(true);
        hotel.setPricePerNight(200);
        hotel.setCreatedAt(LocalDateTime.now());

        trip.setHotel(hotel);
        hotel.setTrip(trip);

        tripService.saveTripWithHotel(trip);

        List<Booking> fullBookings = bookingService.findCompleteBookingInfo();

        System.out.println("=== COMPLETE BOOKING INFO ===");

        for (Booking b : fullBookings) {
            System.out.println(
                    "Booking ID: " + b.getId() +
                            ", User: " + b.getUser().getFirstName() + " " + b.getUser().getLastName() +
                            ", Trip: " + b.getTrip().getTitle() +
                            ", Flight: " + b.getTrip().getFlight().getAirline() +
                            ", Package: " + b.getTrip().getTravelPackage().getName() +
                            ", Payment: " + b.getPayment().getAmount()
            );
        }

        List<Flight> flights = flightService.findAll();
        System.out.println("Total flights: " + flights.size());

        List<Trip> trips = tripService.findAll();
        System.out.println("Total trips: " + trips.size());

        List<User> users = userService.findAll();
        System.out.println("Total users: " + users.size());
    }
}