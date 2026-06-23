package com.solvd.tests;

import com.travel.booking.model.*;
import com.travel.booking.service.impl.BookingServiceImpl;
import com.travel.booking.service.impl.PaymentServiceImpl;
import com.travel.booking.service.impl.TripServiceImpl;
import com.travel.booking.service.impl.UserServiceImpl;
import com.travel.booking.service.interfaces.BookingService;
import com.travel.booking.service.interfaces.PaymentService;
import com.travel.booking.service.interfaces.TripService;
import com.travel.booking.service.interfaces.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BookingTests {

    private BookingService bookingService;
    private UserService userService;
    private PaymentService paymentService;
    private TripService tripService;

    @BeforeClass
    public void setup() {
        bookingService = new BookingServiceImpl();
        userService = new UserServiceImpl();
        paymentService = new PaymentServiceImpl();
        tripService = new TripServiceImpl();
    }

    private Booking createBooking() {

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john" + System.currentTimeMillis() + "@gmail.com");
        user.setPhoneNumber("555555");
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setCreatedAt(LocalDateTime.now());

        TravelBookingSystem system = new TravelBookingSystem();
        system.setId(1L);
        user.setTravelBookingSystem(system);

        userService.save(user);

        Trip trip = tripService.findAll().getFirst();

        Payment payment = new Payment();
        payment.setPaymentMethod("CARD");
        payment.setAmount(999);
        payment.setSuccessful(true);
        payment.setPaymentDate(LocalDate.now());
        payment.setCreatedAt(LocalDateTime.now());
        paymentService.save(payment);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTrip(trip);
        booking.setPayment(payment);
        booking.setTotalPrice(999);
        booking.setConfirmed(true);
        booking.setBookingDate(LocalDate.now());
        booking.setCreatedAt(LocalDateTime.now());

        bookingService.save(booking);

        return booking;
    }

    @Test
    public void saveBookingTest() {

        Booking booking = createBooking();

        Assert.assertNotNull(booking.getId(),
                "Booking should be saved and have an ID.");
    }

    @Test
    public void findBookingByIdTest() {

        Booking booking = createBooking();

        Booking found =
                bookingService.findById(booking.getId());

        Assert.assertNotNull(found,
                "Booking should be found by ID.");
    }

    @Test
    public void findAllBookingsTest() {

        List<Booking> bookings =
                bookingService.findAll();

        Assert.assertNotNull(bookings,
                "Booking list should not be null.");
    }

    @Test
    public void updateBookingTest() {

        Booking booking = createBooking();

        booking.setConfirmed(false);

        bookingService.update(booking);

        Booking updated =
                bookingService.findById(booking.getId());

        Assert.assertFalse(updated.isConfirmed(),
                "Booking should be updated.");
    }

    @Test
    public void deleteBookingTest() {

        Booking booking = createBooking();

        bookingService.delete(booking.getId());

        Booking deleted =
                bookingService.findById(booking.getId());

        Assert.assertNull(deleted,
                "Deleted booking should not exist.");
    }

    @Test
    public void findCompleteBookingInfoTest() {

        List<Booking> bookings =
                bookingService.findCompleteBookingInfo();

        Assert.assertNotNull(bookings,
                "Complete booking info should not be null.");
    }
}