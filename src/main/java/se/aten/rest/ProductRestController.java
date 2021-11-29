package se.aten.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.aten.domain.Console;
import se.aten.domain.Game;
import se.aten.domain.Product;
import se.aten.repository.ConsoleRepository;
import se.aten.repository.GameRepository;
import se.aten.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Rest API for products
 */
@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ConsoleRepository consoleRepo;
    @Autowired
    private GameRepository gameRepo;

    @GetMapping("/console/{id}")
    public ResponseEntity getConsoleById(@PathVariable("id") long id) {
        Optional<Console> console = consoleRepo.findById(id);
        if (!console.isEmpty()) {
            return new ResponseEntity(console, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/game/{id}")
    public ResponseEntity getGameById(@PathVariable("id") long id) {
        Optional<Game> game = gameRepo.findById(id);
        if (game.isPresent()) {
            return new ResponseEntity(game, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/game")
    public ResponseEntity getAllGames() {
        List<Game> allGames = gameRepo.findAll();
        if (!allGames.isEmpty()) {
            return new ResponseEntity(allGames, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        if (!allProducts.isEmpty()) {
            return new ResponseEntity(allProducts, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
