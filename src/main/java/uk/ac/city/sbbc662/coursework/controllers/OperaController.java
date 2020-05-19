package uk.ac.city.sbbc662.coursework.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * A controller to handle GET requests to the home and opera pages
 *
 */
@Controller
public class OperaController {


    /**
     * Controller method to handle a GET request to the / endpoint (homepage)
     *
     * @return ModelAndView returns a view constructed from index.html (no model required)
     */
    @RequestMapping(value = "/")
    public ModelAndView showHome() {
        return new ModelAndView("index");
    }

    /**
     * Controller method to handle a GET request to the /artist endpoint
     *
     * @return ModelAndView returns a view constructed from artist.html (no model required)
     */
    @RequestMapping(value = "/artist")
    public ModelAndView showArtist() {
        return new ModelAndView("artist");
    }

    @RequestMapping(value = "/ziont")
    public ModelAndView showZionT() {
        return new ModelAndView("ziont");
    }

    @RequestMapping(value = "/gray")
    public ModelAndView showGray() {
        return new ModelAndView("gray");
    }

    @RequestMapping(value = "/loco")
    public ModelAndView showLoco() {
        return new ModelAndView("loco");
    }

    @RequestMapping(value = "/elo")
    public ModelAndView showElo() {
        return new ModelAndView("elo");
    }

    @RequestMapping(value = "/crush")
    public ModelAndView showCrush() {
        return new ModelAndView("crush");
    }


}

