package se.aten.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.aten.domain.User;
import se.aten.domain.UserAddress;
import se.aten.repository.ReceiptRepository;
import se.aten.repository.UserAddressRepository;
import se.aten.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * RestController for User and UserAddress.
 *
 * @author Emma Fredriksson
 * @author Niklas Johansson
 */
@CrossOrigin(origins = {"http://localhost:8081", "https://atenstore.netlify.app/"})
@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserAddressRepository userAddressRepo;
    @Autowired
    private ReceiptRepository receiptRepo;

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
     * Finds one user given its unique user_id.
     *
     * @param id the id of the user to search for
     * @return the user if found
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
     * Finds one user given its unique usernmae.
     *
     * @param username the username of the user to search for
     * @return the user if found
     */
    @GetMapping("/user/{username}")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username) {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Find all with the same lastname.
     *
     * @param lastName the lastname of the user to search for
     * @return a list of users with the specified lastname if found
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
     * @param city a city to search for
     * @return a list of addresses in the specified city
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

    /**
     * Creates a user and saves it in the database.
     *
     * @param user the user
     * @return status 400 if username or password is missing,
     * else returns status 200 if everything went okay
     */
    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            UserAddress address = new UserAddress(user.getUserAddresses().get(0).getAddress(),
                    user.getUserAddresses().get(0).getZipcode(), user.getUserAddresses().get(0).getCity(),
                    user.getUserAddresses().get(0).getCountry(), user.getUserAddresses().get(0).getPhoneNumber());
            User newUser = new User(user.getUsername(), user.getPassword(), user.getFirstName(),
                    user.getLastName(), address);
            address.setUser(newUser);
            userRepo.save(newUser);
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }

    /**
     * Method for logging in, checks if the password matches the password of the user trying
     * to log in.
     *
     * @param username the specified username
     * @param password the password of said username
     * @return status 400 if either username or password is missing,
     * or if the password does not match said username,
     * else return status 200 if everything went okay.
     */
    @GetMapping("/loginRequest/{username}&{password}")
    public ResponseEntity loginRequest(@PathVariable("username") String username, @PathVariable("password") String password) {
        if (username == null || password == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            User user = userRepo.findByUsername(username);

            if (user != null) {
                if (user.getPassword().equals(password)) {
                    return new ResponseEntity(user, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
    }
}