package se.aten.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.aten.domain.*;
import se.aten.repository.ConsoleRepository;
import se.aten.repository.GameRepository;
import se.aten.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Rest API for products
 * @author Alexander Gabay, Tom Karlsson, Emma Fredriksson, Niklas Johansson
 */
@CrossOrigin(origins = { "http://localhost:8081", "https://atenstore.netlify.app/"})
@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ConsoleRepository consoleRepo;
    @Autowired
    private GameRepository gameRepo;

    /**
     * Finds all products, both games and consoles.
     */
    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        if (!allProducts.isEmpty()) {
            return new ResponseEntity(allProducts, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Finds all products given its name.
     * @param name the name of the product to search for
     * @return a list of products with the specified name
     */
    @GetMapping("/products/{name}")
    public ResponseEntity getProductByName(@PathVariable("name")String name) {
        List<Product> allProductsByName = productRepo.findByName(name);
        if (!allProductsByName.isEmpty()) {
            return new ResponseEntity(allProductsByName, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Finds all consoles.
     */
    @GetMapping("/allConsoles")
    public ResponseEntity getAllConsoles() {
        List<Console> allConsoles = consoleRepo.findAll();
        if (!allConsoles.isEmpty()) {
            return new ResponseEntity(allConsoles, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Find a specific console given its ID.
     * @param id the id of the console to search for
     * @return the found console if any
     */
    @GetMapping("/console/{id}")
    public ResponseEntity getConsoleById(@PathVariable("id") long id) {
        Optional<Console> console = consoleRepo.findById(id);
        if (!console.isEmpty()) {
            return new ResponseEntity(console, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Finds all consoles of a specific brand.
     * @param brand
     * @return a list of consoles in the specific brand
     */
    @GetMapping("/consoles/{brand}")
    public ResponseEntity getConsoleByBrand(@PathVariable("brand")ConsoleType brand) {
        List<Console> allConsoleByBrand = consoleRepo.findByBrand(brand);
        if (!allConsoleByBrand.isEmpty()) {
            return new ResponseEntity(allConsoleByBrand, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Finds all games.
     */
    @GetMapping("/allGames")
    public ResponseEntity getAllGames() {
        List<Game> allGames = gameRepo.findAll();
        if (!allGames.isEmpty()) {
            return new ResponseEntity(allGames, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Finds a specific game given its ID.
     * @param id
     * @return the found game if any
     */
    @GetMapping("/game/{id}")
    public ResponseEntity getGameById(@PathVariable("id") long id) {
        Optional<Game> game = gameRepo.findById(id);
        if (game.isPresent()) {
            return new ResponseEntity(game, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Finds all games of a specific genre.
     * @param genre
     * @return a list of games in the specific genre
     */
    @GetMapping("/games/{genre}")
    public ResponseEntity getGameByGenre(@PathVariable("genre") Genre genre) {
        List<Game> allGamesByGenre = gameRepo.findByGenre(genre);
        if (!allGamesByGenre.isEmpty()) {
            return new ResponseEntity(allGamesByGenre, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
