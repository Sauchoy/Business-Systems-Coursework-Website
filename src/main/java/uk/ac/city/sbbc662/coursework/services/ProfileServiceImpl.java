package uk.ac.city.sbbc662.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.sbbc662.coursework.dao.BookingRepository;
import uk.ac.city.sbbc662.coursework.dao.HistoryRepository;
import uk.ac.city.sbbc662.coursework.dao.OperaRepository;
import uk.ac.city.sbbc662.coursework.entites.Booking;
import uk.ac.city.sbbc662.coursework.entites.CollatedUser;
import uk.ac.city.sbbc662.coursework.entites.LoginHistory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {


    /**
     * The repository for opera user data.
     */
    private OperaRepository operaRepository;
    /**
     * The repository for booking data.
     */
    private BookingRepository bookingRepository;
    /**
     * The repository for login history.
     */
    private HistoryRepository historyRepository;


    /**
     *
     * Constructor based dependency injection of repositories.
     *
     * @param operaRepository the opera user repo
     * @param bookingRepository the booking repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public ProfileServiceImpl(OperaRepository operaRepository,
                                     BookingRepository bookingRepository,
                                     HistoryRepository historyRepository){
        this.operaRepository = operaRepository;
        this.bookingRepository = bookingRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * The implemented method that collates all the current users information
     * into a single object that will back the profile.html view
     *
     * @param email the current user's email
     * @return CollatedUser a object that aggregates all the user's data.
     */
    @Override
    public CollatedUser getProfile(String email) {
        CollatedUser user = new CollatedUser();
        user.setOperaUser(operaRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));
        List<Booking> bookings = bookingRepository.findAll()
                .stream().filter(booking -> booking.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setBookings(bookings);
        List<LoginHistory> history = historyRepository.findAll()
                .stream().filter(loginHistory -> loginHistory.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setLogins(history);
        return user;
    }
}
