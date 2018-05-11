package com.dancestudiois.controller;

import com.dancestudiois.model.Choreographer;
import com.dancestudiois.service.ChoreographerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/choreographer")
public class ChoreographerController {
    private static final Logger logger = LoggerFactory.getLogger(ChoreographerController.class);
   /* @Autowired
    private ChoreographerService choreographerService;*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result = new ModelAndView();
        result.addObject("name", "Darya");
        result.setViewName("index");
        return result;
    }
}
