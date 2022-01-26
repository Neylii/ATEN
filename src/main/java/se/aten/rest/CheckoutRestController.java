package se.aten.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.aten.domain.Product;
import se.aten.service.CheckoutService;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081", "https://atenstore.netlify.app/"})
@RestController
@RequestMapping("/api")
public class CheckoutRestController {
    @Autowired
    @Qualifier("checkoutService")
    private CheckoutService checkoutService;

    /**
     *
     * @param productsInCart
     * @param id
     * @return
     */
    @RequestMapping(value = "/checkout/{id}", method = RequestMethod.POST)
    public ResponseEntity checkout(@RequestBody List<Product> productsInCart, @PathVariable("id") long id) {
        if (productsInCart.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            checkoutService.checkout(id, productsInCart);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
