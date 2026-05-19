package com.travel.booking.service.impl;

import com.travel.booking.dao.impl.BookingDaoImpl;
import com.travel.booking.dao.interfaces.BookingDao;
import com.travel.booking.model.Booking;
import com.travel.booking.service.interfaces.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao = new BookingDaoImpl();

    @Override
    public void save(Booking booking) {
        bookingDao.create(booking);
    }

    @Override
    public Booking findById(Long id) {
        return bookingDao.findBy(id);
    }

    @Override
    public List<Booking> findAll() {
        return bookingDao.findAll();
    }

    @Override
    public void update(Booking booking) {
        bookingDao.update(booking);
    }

    @Override
    public void delete(Long id) {
        bookingDao.delete(id);
    }

    @Override
    public List<Booking> findCompleteBookingInfo() {
        return bookingDao.findCompleteBookingInfo();
    }
}
