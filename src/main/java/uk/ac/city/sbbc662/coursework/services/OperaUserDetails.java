package uk.ac.city.sbbc662.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.sbbc662.coursework.dao.HistoryRepository;
import uk.ac.city.sbbc662.coursework.dao.OperaRepository;
import uk.ac.city.sbbc662.coursework.entites.LoginHistory;
import uk.ac.city.sbbc662.coursework.entites.OperaUser;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Custom authentication service which includes recording login history
 * each time a user is authenticated.
 */
@Service
public class OperaUserDetails implements UserDetailsService {


    /**
     * The repository for opera user data.
     */
    private OperaRepository operaRepository;
    /**
     * The repository for login history
     */
    private HistoryRepository historyRepository;

    /**
     * Constructo based dependency injection of repositories.
     *
     * @param operaRepository the opera user repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public OperaUserDetails(OperaRepository operaRepository, HistoryRepository historyRepository){
        this.operaRepository = operaRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * The override fo the UserDetailsService method that validates a user. The methods finds the
     * user in the database based on the String s provided by the users login credentials (their email
     * address)
     *
     * @param s user's email address provided when logging in.
     * @return UserDetails an object representing the user including their password, account status and roles
     * @throws UsernameNotFoundException if the user cannot be found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        OperaUser operaUser = operaRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching user."));
        //if the first line does not throw the exception the login history
        //object will be constructed and saved to the database.
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setEmail(operaUser.getEmail());
        loginHistory.setTime(LocalDateTime.now());
        historyRepository.save(loginHistory);
        //and a UserDetails object will be constructed and returned.
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(operaUser.getAuthoritiy()));
        return new User
                (operaUser.getEmail(), operaUser.getPassword(), operaUser.getEnabled(),
                        true, true, true, authorities);

    }
}
