package com.travel.booking.designpatterns.factories.interfaces;

import com.travel.booking.dao.interfaces.*;

public interface DaoFactory {
    UserDao getUserDao();
    BookingDao getBookingDao();
    DestinationDao getDestinationDao();
    HotelDao getHotelDao();
    PaymentDao getPaymentDao();
    ReviewDao getReviewDao();
    TransportDao getTransportDao();
    TravelBookingSystemDao getTravelBookingSystemDao();
    TravelPackageDao getTravelPackageDao();
    TripDao getTripDao();
}
