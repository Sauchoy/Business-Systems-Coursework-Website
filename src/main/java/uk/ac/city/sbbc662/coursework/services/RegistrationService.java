package uk.ac.city.sbbc662.coursework.services;

import uk.ac.city.sbbc662.coursework.dao.OperaRepository;
import uk.ac.city.sbbc662.coursework.entites.OperaUser;

/**
 * Registration service interface that specifies a method to save user information to the database.
 */
public interface RegistrationService {

    void registerUser(OperaUser operaUser);
}
