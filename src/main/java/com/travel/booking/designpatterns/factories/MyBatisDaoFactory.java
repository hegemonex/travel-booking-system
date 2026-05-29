package com.travel.booking.designpatterns.factories;

import com.travel.booking.dao.interfaces.*;
import com.travel.booking.designpatterns.factories.interfaces.DaoFactory;
import com.travel.booking.mybatis.mybatisdao.*;

public class MyBatisDaoFactory implements DaoFactory {
    @Override
    public UserDao getUserDao() {
        return new UserBatisDao();
    }

    @Override
    public BookingDao getBookingDao() {
        return new BookingBatisDao();
    }

    @Override
    public DestinationDao getDestinationDao() {
        return new DestinationBatisDao();
    }

    @Override
    public HotelDao getHotelDao() {
        return new HotelBatisDao();
    }

    @Override
    public PaymentDao getPaymentDao() {
        return new PaymentBatisDao();
    }

    @Override
    public ReviewDao getReviewDao() {
        return new ReviewBatisDao();
    }

    @Override
    public TransportDao getTransportDao() {
        return new TransportBatisDao();
    }

    @Override
    public TravelBookingSystemDao getTravelBookingSystemDao() {
        return new TravelBookingSystemBatisDao();
    }

    @Override
    public TravelPackageDao getTravelPackageDao() {
        return new TravelPackageBatisDao();
    }

    @Override
    public TripDao getTripDao() {
        return new TrisBatisDao();
    }
}
