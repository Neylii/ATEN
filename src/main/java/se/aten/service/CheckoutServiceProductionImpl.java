package se.aten.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.aten.domain.Product;
import se.aten.domain.Receipt;
import se.aten.domain.User;
import se.aten.repository.UserRepository;

import java.util.List;

public class CheckoutServiceProductionImpl implements CheckoutService {
    @Autowired
    UserRepository userRepo;

    /**
     * @param userId
     * @param products List of products that was added to the users cart before checking out
     * @author Niklas Johansson
     */
    @Override
    public void checkout(long userId, List<Product> products) {
        User user = userRepo.getById(userId);

        double total = calculateTotalPrice(products);
        createNewReceipt(user, products, total);
        userRepo.save(user);
    }

    /**
     * Calculates the total price of all products in the Users cart
     *
     * @param products
     * @return the sum of all the products
     */
    public double calculateTotalPrice(List<Product> products) {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    /**
     * Creates a new receipt for the purchase
     *
     * @param user     The User that is buying the products
     * @param products All products in the Users cart
     * @param total    Total sum of all products in the Users cart
     */
    public void createNewReceipt(User user, List<Product> products, double total) {
        Receipt receipt = new Receipt(products, total);
        receipt.setUser(user);
        user.addReceipt(receipt);
    }
}
