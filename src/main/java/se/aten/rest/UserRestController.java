package se.aten.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.aten.domain.User;
import se.aten.domain.UserAddress;
import se.aten.repository.UserAddressRepository;
import se.aten.repository.UserRepository;
import java.util.List;
import java.util.Optional;

/**
 * RestController for User and UserAddress.
 *
 * @author Emma Fredriksson
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserAddressRepository userAddressRepo;

    /**
     * Finds all users
     */
    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        if (!allUsers.isEmpty()) {
            return new ResponseEntity(allUsers, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Finds one user given it's unique user_id.
     *
     * @param id
     * @return the user.
     */
    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        Optional<User> user = userRepo.findById(id);
        if (!user.isEmpty()) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Find all with the same lastname.
     *
     * @param lastName
     */
    @GetMapping("/users/{lastName}")
    public ResponseEntity getUserByLastName(@PathVariable("lastName") String lastName) {
        List<User> userByLastname = userRepo.findByLastName(lastName);
        if (!userByLastname.isEmpty()) {
            return new ResponseEntity(userByLastname, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Finds all the addresses and which user they belong to.
     */
    @GetMapping("/userAddress")
    public ResponseEntity getAllAddresses() {
        List<UserAddress> allUserAddresses = userAddressRepo.findAll();
        if (!allUserAddresses.isEmpty()) {
            return new ResponseEntity(allUserAddresses, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Finds all addresses given a city
     *
     * @param city
     */
    @GetMapping("/usersAddress/{city}")
    public ResponseEntity getAddressByCity(@PathVariable("city") String city) {
        List<UserAddress> allAddressesByCity = userAddressRepo.findByCity(city);
        if (!allAddressesByCity.isEmpty()) {
            return new ResponseEntity(allAddressesByCity, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
