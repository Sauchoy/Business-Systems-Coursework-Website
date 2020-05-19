package uk.ac.city.sbbc662.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.sbbc662.coursework.entites.OperaUser;
import uk.ac.city.sbbc662.coursework.services.RegistrationService;

@Controller
public class RegistrationController {

    /**
     * The registration service which is used to save user information to the
     * database.
     */
    private RegistrationService registrationService;

    /**
     * Constructor based dependency injection of the registration service
     *
     * @param registrationService
     */
    @Autowired
    public RegistrationController (RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    /**
     * Controller method for responding to a GET request to the /register endpoint
     *
     * @return ModelAndView a view created from register.html backed by an OperaUser object
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistation(){
        OperaUser operaUser = new OperaUser();
        return new ModelAndView("register", "operaUser", operaUser);
    }

    /**
     * Controller method to handle a POST request to the /register endpoint
     *
     * @param operaUser an object containing the data from the registration form
     * @return String a redirect to the profile page (which requries the user to login)
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistation(OperaUser operaUser){
        operaUser.setEnabled(Boolean.TRUE);
        operaUser.setAuthoritiy("ROLE_USER");
        registrationService.registerUser(operaUser);
        return "redirect:/profile";
    }


}
