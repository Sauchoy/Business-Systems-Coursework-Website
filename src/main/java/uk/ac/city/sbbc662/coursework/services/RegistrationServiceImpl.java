package uk.ac.city.sbbc662.coursework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.sbbc662.coursework.dao.OperaRepository;
import uk.ac.city.sbbc662.coursework.entites.OperaUser;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    /**
     * The repository for opera user data.
     */
    private OperaRepository operaRepository;

    /**
     * Constructor based dependency injection
     *
     * @param operaRepository the opera user repo.
     */
    @Autowired
    public RegistrationServiceImpl(OperaRepository operaRepository){
        this.operaRepository = operaRepository;
    }

    /**
     * Saves an opera user to the database.
     *
     * @param operaUser the opera user to be saved.
     */
    @Override
    public void registerUser(OperaUser operaUser) {
        operaRepository.save(operaUser);
    }
}
