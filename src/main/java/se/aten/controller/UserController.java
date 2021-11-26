package se.aten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import se.aten.domain.User;
import se.aten.domain.UserAddress;
import se.aten.repository.UserRepository;

/**
 * Controller for creating an account
 *
 * @author Emma Fredriksson
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/newUser.html", method = RequestMethod.GET)
    public ModelAndView renderNewUserForm() {
        // create new user
        User newUser = new User();
        return new ModelAndView("newUser", "form", newUser);
    }

    @RequestMapping(value = "/newUser.html", method = RequestMethod.POST)
    public String newUser(User user) {
        // Hardcoded address for now, needs to change
        UserAddress userAddress = new UserAddress("Götagatan 1", "Göteborg", "Sweden", "031-111");

        // Sets the right user to the userAddress to make the foreign key work
        userAddress.setUser(user);

        // Add the address to the users list<> of addresses
        user.addAddress(userAddress);

        // save user in database with the help of repository
        userRepo.save(user);
        return "redirect:/login.html";
    }

    @RequestMapping(value = "/login.html")
    public ModelAndView loginPage() {
        // Just to get another page for now
        return new ModelAndView("login");
    }
}