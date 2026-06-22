package com.solvd.tests;

import com.travel.booking.model.Booking;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingTests extends BaseTests {

    @Test
    public void shouldSetTotalPrice() {
        Booking booking = new Booking();

        booking.setTotalPrice(1200);

        Assert.assertEquals(booking.getTotalPrice(), 1200.0);
    }

    @Test
    public void shouldSetConfirmed() {
        Booking booking = new Booking();

        booking.setConfirmed(true);

        Assert.assertTrue(booking.isConfirmed());
    }

    @Test
    public void shouldSetBookingDate() {
        Booking booking = new Booking();

        LocalDate date = LocalDate.now();

        booking.setBookingDate(date);

        Assert.assertEquals(booking.getBookingDate(), date);
    }

    @Test
    public void shouldSetCreatedAt() {
        Booking booking = new Booking();

        LocalDateTime now = LocalDateTime.now();

        booking.setCreatedAt(now);

        Assert.assertEquals(booking.getCreatedAt(), now);
    }

    @Test
    public void bookingShouldNotBeConfirmedInitially() {
        Booking booking = new Booking();

        booking.setConfirmed(false);

        Assert.assertFalse(booking.isConfirmed());
    }
}