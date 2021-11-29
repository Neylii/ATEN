package se.aten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.aten.domain.*;
import se.aten.repository.ConsoleRepository;
import se.aten.repository.GameRepository;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    GameRepository GameRepo;
    @Autowired
    ConsoleRepository ConRepo;

    @RequestMapping("/home.html")
    public ModelAndView firstPage() {

        List<Game> allArticles = GameRepo.findAll();

        return new ModelAndView("home", "articles", allArticles);
    }

}
