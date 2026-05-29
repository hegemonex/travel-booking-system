import com.travel.booking.designpatterns.factories.MyBatisServiceFactory;
import com.travel.booking.designpatterns.factories.interfaces.ServiceFactory;
import com.travel.booking.model.*;
import com.travel.booking.service.interfaces.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        ServiceFactory factory = new MyBatisServiceFactory();

        TravelBookingSystemService tbsService  = factory.createTravelBookingSystemService();
        TransportService           transportService = factory.createTransportService();
        TravelPackageService       packageService   = factory.createTravelPackageService();
        FlightService              flightService    = factory.createFlightService();
        UserService                userService      = factory.createUserService();
        DestinationService         destinationService = factory.createDestinationService();
        TripService                tripService      = factory.createTripService();
        BookingService             bookingService   = factory.createBookingService();
        ReviewService              reviewService    = factory.createReviewService();
        PaymentService             paymentService   = factory.createPaymentService();

        TravelBookingSystem tbs = new TravelBookingSystem.Builder()
                .systemName("Main System")
                .createdAt(LocalDateTime.now())
                .build();
        tbsService.save(tbs);
        System.out.println("TBS ID = " + tbs.getId());

        Transport transport = new Transport.Builder()
                .type("Bus")
                .capacity(50)
                .available(true)
                .transportPrice(50)
                .createdAt(LocalDateTime.now())
                .build();
        transportService.save(transport);

        Flight flight = new Flight.Builder()
                .airline("Georgian Airways")
                .departureAirport("TBS")
                .arrivalAirport("LHR")
                .departureDate(LocalDate.of(2025, 6, 1))
                .arrivalDate(LocalDate.of(2025, 6, 1))
                .directFlight(true)
                .ticketPrice(300)
                .createdAt(LocalDateTime.now())
                .build();
        flightService.save(flight);

        TravelPackage pack = new TravelPackage.Builder()
                .name("London Package")
                .description("All inclusive")
                .packagePrice(1200)
                .active(true)
                .startDate(LocalDate.of(2025, 6, 1))
                .endDate(LocalDate.of(2025, 6, 6))
                .createdAt(LocalDateTime.now())
                .travelBookingSystem(tbs)
                .build();
        packageService.save(pack);

        User user = new User.Builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .phoneNumber("555-123")
                .birthDate(LocalDate.of(1990, 1, 1))
                .createdAt(LocalDateTime.now())
                .travelBookingSystem(tbs)
                .build();
        userService.save(user);

        Destination dest = new Destination.Builder()
                .country("UK")
                .city("London")
                .description("Capital")
                .visaRequired(false)
                .createdAt(LocalDateTime.now())
                .build();
        destinationService.save(dest);

        Hotel hotel = new Hotel.Builder()
                .name("Hilton")
                .city("London")
                .address("Central")
                .starRating(5)
                .breakfastIncluded(true)
                .pricePerNight(200)
                .createdAt(LocalDateTime.now())
                .build();

        Trip trip = new Trip.Builder()
                .title("London Trip")
                .description("5 days")
                .price(999)
                .available(true)
                .departureDate(LocalDate.of(2025, 6, 1))
                .returnDate(LocalDate.of(2025, 6, 6))
                .createdAt(LocalDate.now())
                .flight(flight)
                .transport(transport)
                .travelPackage(pack)
                .travelBookingSystem(tbs)
                .hotel(hotel)
                .build();

        tripService.saveTripWithHotel(trip);

        Review review = new Review.Builder()
                .user(user)
                .trip(trip)
                .rating(5)
                .comment("Amazing!")
                .recommended(true)
                .reviewDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .build();
        reviewService.save(review);

        Payment payment = new Payment.Builder()
                .paymentMethod("CARD")
                .amount(trip.getPrice())
                .successful(true)
                .paymentDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .build();
        paymentService.save(payment);

        Booking booking = new Booking.Builder()
                .user(user)
                .trip(trip)
                .payment(payment)
                .totalPrice(trip.getPrice())
                .confirmed(true)
                .bookingDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .build();
        bookingService.save(booking);

        System.out.println("Trips: "            + tripService.findAll().size());
        System.out.println("Users: "            + userService.findAll().size());
        System.out.println("Bookings complete: " + bookingService.findCompleteBookingInfo().size());
    }
}