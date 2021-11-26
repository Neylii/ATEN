package se.aten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import se.aten.domain.User;
import se.aten.repository.UserRepository;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/newUser.html", method = RequestMethod.POST)
    public String newUser(User user) {
        userRepo.save(user);
        return "redirect:/newUser.html";
    }

    @RequestMapping(value = "/newUser.html", method = RequestMethod.GET)
    public ModelAndView renderNewUserForm() {
        User newUser = new User();
        return new ModelAndView("newUser", "form", newUser);
    }
}