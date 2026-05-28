import com.travel.booking.model.*;
import com.travel.booking.service.impl.*;
import com.travel.booking.service.interfaces.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        TravelBookingSystemService tbsService = new TravelBookingSystemServiceImpl();
        TransportService transportService = new TransportServiceImpl();
        TravelPackageService packageService = new TravelPackageServiceImpl();
        FlightService flightService = new FlightServiceImpl();
        UserService userService = new UserServiceImpl();
        DestinationService destinationService = new DestinationServiceImpl();
        TripService tripService = new TripServiceImpl();
        BookingService bookingService = new BookingServiceImpl();
        ReviewService reviewService = new ReviewServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();

        TravelBookingSystem tbs = new TravelBookingSystem();
        tbs.setSystemName("Main System");
        tbs.setCreatedAt(LocalDateTime.now());
        tbsService.save(tbs);

        System.out.println("TBS ID = " + tbs.getId());

        Transport transport = new Transport();
        transport.setType("Bus");
        transport.setCapacity(50);
        transport.setAvailable(true);
        transport.setTransportPrice(50);
        transport.setCreatedAt(LocalDateTime.now());
        transportService.save(transport);

        Flight flight = new Flight();
        flight.setAirline("Georgian Airways");
        flight.setDepartureAirport("TBS");
        flight.setArrivalAirport("LHR");
        flight.setDepartureDate(LocalDate.of(2025, 6, 1));
        flight.setArrivalDate(LocalDate.of(2025, 6, 1));
        flight.setDirectFlight(true);
        flight.setTicketPrice(300);
        flight.setCreatedAt(LocalDateTime.now());
        flightService.save(flight);

        TravelPackage pack = new TravelPackage();
        pack.setName("London Package");
        pack.setDescription("All inclusive");
        pack.setPackagePrice(1200);
        pack.setActive(true);
        pack.setStartDate(LocalDate.of(2025, 6, 1));
        pack.setEndDate(LocalDate.of(2025, 6, 6));
        pack.setCreatedAt(LocalDateTime.now());
        pack.setTravelBookingSystem(tbs);
        packageService.save(pack);

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@gmail.com");
        user.setPhoneNumber("555-123");
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setCreatedAt(LocalDateTime.now());
        user.setTravelBookingSystem(tbs);
        userService.save(user);

        Destination dest = new Destination();
        dest.setCountry("UK");
        dest.setCity("London");
        dest.setDescription("Capital");
        dest.setVisaRequired(false);
        dest.setCreatedAt(LocalDateTime.now());
        destinationService.save(dest);

        Trip trip = new Trip();
        trip.setTitle("London Trip");
        trip.setDescription("5 days");
        trip.setPrice(999);
        trip.setAvailabe(true);
        trip.setDepartureDate(LocalDate.of(2025, 6, 1));
        trip.setReturnDate(LocalDate.of(2025, 6, 6));
        trip.setCreatedAt(LocalDate.now());

        trip.setFlight(flight);
        trip.setTransport(transport);
        trip.setTravelPackage(pack);
        trip.setTravelBookingSystem(tbs);
        trip.setHotel(buildHotel());

        tripService.saveTripWithHotel(trip);

        Review review = new Review();
        review.setUser(user);
        review.setTrip(trip);
        review.setRating(5);
        review.setComment("Amazing!");
        review.setRecommended(true);
        review.setReviewDate(LocalDate.now());
        review.setCreatedAt(LocalDateTime.now());

        reviewService.save(review);

        Payment payment = new Payment();
        payment.setPaymentMethod("CARD");
        payment.setAmount(trip.getPrice());
        payment.setSuccessful(true);
        payment.setPaymentDate(LocalDate.now());
        payment.setCreatedAt(LocalDateTime.now());

        paymentService.save(payment);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTrip(trip);
        booking.setPayment(payment);
        booking.setTotalPrice(trip.getPrice());
        booking.setConfirmed(true);
        booking.setBookingDate(LocalDate.now());
        booking.setCreatedAt(LocalDateTime.now());

        bookingService.save(booking);

        System.out.println("Trips: " + tripService.findAll().size());
        System.out.println("Users: " + userService.findAll().size());
        System.out.println("Bookings complete: " + bookingService.findCompleteBookingInfo().size());
    }

    private static Hotel buildHotel() {
        Hotel hotel = new Hotel();
        hotel.setName("Hilton");
        hotel.setCity("London");
        hotel.setAddress("Central");
        hotel.setStarRating(5);
        hotel.setBreakfastIncluded(true);
        hotel.setPricePerNight(200);
        hotel.setCreatedAt(LocalDateTime.now());
        return hotel;
    }
}