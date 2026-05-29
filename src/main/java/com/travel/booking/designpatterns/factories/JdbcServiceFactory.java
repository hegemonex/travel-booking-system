package com.travel.booking.designpatterns.factories;

import com.travel.booking.dao.impl.*;
import com.travel.booking.designpatterns.factories.interfaces.ServiceFactory;
import com.travel.booking.service.interfaces.*;

public class JdbcServiceFactory implements ServiceFactory {

    @Override
    public UserService createUserService() {
        UserDaoImpl dao = new UserDaoImpl();
        return new UserService() {
            public void save(com.travel.booking.model.User u) {
                dao.create(u);
            }

            public com.travel.booking.model.User findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.User> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.User u) {
                dao.update(u);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }

    @Override
    public BookingService createBookingService() {
        BookingDaoImpl dao = new BookingDaoImpl();
        return new BookingService() {
            public void save(com.travel.booking.model.Booking b) {
                dao.create(b);
            }

            public com.travel.booking.model.Booking findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.Booking> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.Booking b) {
                dao.update(b);
            }

            public void delete(Long id) {
                dao.delete(id);
            }

            public java.util.List<com.travel.booking.model.Booking> findCompleteBookingInfo() {
                return dao.findCompleteBookingInfo();
            }
        };
    }

    @Override
    public FlightService createFlightService() {
        FlightDaoImpl dao = new FlightDaoImpl();
        return new FlightService() {
            public void save(com.travel.booking.model.Flight f) {
                dao.create(f);
            }

            public com.travel.booking.model.Flight findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.Flight> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.Flight f) {
                dao.update(f);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }

    @Override
    public HotelService createHotelService() {
        HotelDaoImpl dao = new HotelDaoImpl();
        return new HotelService() {
            public void save(com.travel.booking.model.Hotel h) {
                dao.create(h);
            }

            public com.travel.booking.model.Hotel findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.Hotel> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.Hotel h) {
                dao.update(h);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }

    @Override
    public PaymentService createPaymentService() {
        PaymentDaoImpl dao = new PaymentDaoImpl();
        return new PaymentService() {
            public void save(com.travel.booking.model.Payment p) {
                dao.create(p);
            }

            public com.travel.booking.model.Payment findById(Long id) {
                return dao.findBy(id);
            }
        };
    }

    @Override
    public ReviewService createReviewService() {
        ReviewDaoImpl dao = new ReviewDaoImpl();
        return new ReviewService() {
            public void save(com.travel.booking.model.Review r) {
                dao.create(r);
            }

            public com.travel.booking.model.Review findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.Review> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.Review r) {
                dao.update(r);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }

    @Override
    public TransportService createTransportService() {
        TransportDaoImpl dao = new TransportDaoImpl();
        return new TransportService() {
            public void save(com.travel.booking.model.Transport t) {
                dao.create(t);
            }

            public com.travel.booking.model.Transport findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.Transport> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.Transport t) {
                dao.update(t);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }

    @Override
    public TravelBookingSystemService createTravelBookingSystemService() {
        TravelBookingSystemDaoImpl dao = new TravelBookingSystemDaoImpl();
        return new TravelBookingSystemService() {
            public void save(com.travel.booking.model.TravelBookingSystem s) {
                dao.create(s);
            }

            public com.travel.booking.model.TravelBookingSystem findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.TravelBookingSystem> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.TravelBookingSystem s) {
                dao.update(s);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }

    @Override
    public TravelPackageService createTravelPackageService() {
        TravelPackageDaoImpl dao = new TravelPackageDaoImpl();
        return new TravelPackageService() {
            public void save(com.travel.booking.model.TravelPackage p) {
                dao.create(p);
            }

            public com.travel.booking.model.TravelPackage findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.TravelPackage> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.TravelPackage p) {
                dao.update(p);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }

    @Override
    public TripService createTripService() {
        TripDaoImpl dao = new TripDaoImpl();
        return new TripService() {
            public void save(com.travel.booking.model.Trip t) {
                dao.create(t);
            }

            public com.travel.booking.model.Trip findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.Trip> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.Trip t) {
                dao.update(t);
            }

            public void delete(Long id) {
                dao.delete(id);
            }

            public void saveTripWithHotel(com.travel.booking.model.Trip t) {
                save(t);
            }
        };
    }

    @Override
    public DestinationService createDestinationService() {
        DestinationDaoImpl dao = new DestinationDaoImpl();
        return new DestinationService() {
            public void save(com.travel.booking.model.Destination d) {
                dao.create(d);
            }

            public com.travel.booking.model.Destination findById(Long id) {
                return dao.findBy(id);
            }

            public java.util.List<com.travel.booking.model.Destination> findAll() {
                return dao.findAll();
            }

            public void update(com.travel.booking.model.Destination d) {
                dao.update(d);
            }

            public void delete(Long id) {
                dao.delete(id);
            }
        };
    }
}