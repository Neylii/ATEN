package se.aten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import se.aten.domain.Product;
import se.aten.domain.ProductCategory;
import se.aten.domain.ProductInventory;
import se.aten.repository.ArticleRepository;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    ArticleRepository artRepo;

    @RequestMapping("/home.html")
    public ModelAndView firstPage() {

        ProductCategory game = new ProductCategory("Game", "Different kind of games");
        ProductInventory bosse = new ProductInventory(100);
        ProductInventory nisse = new ProductInventory(50);

        Product firstArticle = new Product("apelem", "lol", "APLOL", 50.00, game, bosse);
        Product secondArticle = new Product("appelem", "asda", "APASDA", 50.00, game, nisse);
        artRepo.save(firstArticle);
        artRepo.save(secondArticle);
        List<Product> allArticles = artRepo.findAll();

        return new ModelAndView("home", "articles", allArticles);
    }

}
