package se.aten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

    @RequestMapping("/home.html")
    public ModelAndView firstPage() {
        return new ModelAndView("home");
    }

}
