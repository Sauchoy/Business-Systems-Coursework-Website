package uk.ac.city.sbbc662.coursework.entites;

import java.util.List;
/**
 * An Entity class representing all of the information relevant to a specific operauser including
 * their bookings and login history.
 *
 * */
public class CollatedUser{

    private OperaUser operaUser;
    private List<Booking> bookings;
    private List<LoginHistory> logins;

    public OperaUser getOperaUser() {
        return operaUser;
    }

    public void setOperaUser(OperaUser operaUser) {
        this.operaUser = operaUser;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }
}
