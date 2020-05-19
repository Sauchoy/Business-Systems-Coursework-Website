package uk.ac.city.sbbc662.coursework.services;

import uk.ac.city.sbbc662.coursework.entites.Booking;

/**
 * A service interface containing methods used by the controllers
 * to record and retrieve booking information.
 */
public interface BookingService {

    void makeBooking(Booking booking);
}
