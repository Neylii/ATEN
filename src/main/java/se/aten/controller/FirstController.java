package se.aten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.aten.domain.Article;
import se.aten.repository.ArticleRepository;

@Controller
public class FirstController {

    @Autowired
    ArticleRepository artRepo;

    @RequestMapping("/home.html")
    public ModelAndView firstPage() {

        Article firstArticle = new Article("apelem", 50.00);
        Article secondArticle = new Article("appelem", 50.00);
        artRepo.save(firstArticle);
        artRepo.save(secondArticle);

        return new ModelAndView("home");
    }

}
