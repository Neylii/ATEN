package se.aten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.aten.domain.Product;
import se.aten.repository.ArticleRepository;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    ArticleRepository artRepo;

    @RequestMapping("/home.html")
    public ModelAndView firstPage() {

        Product firstArticle = new Product("apelem", 50.00);
        Product secondArticle = new Product("appelem", 50.00);
        artRepo.save(firstArticle);
        artRepo.save(secondArticle);
        List<Product> allArticles = artRepo.findAll();

        return new ModelAndView("home", "articles", allArticles);
    }

}
