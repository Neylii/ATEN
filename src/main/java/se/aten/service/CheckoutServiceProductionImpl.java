package se.aten.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.aten.domain.Product;
import se.aten.domain.Receipt;
import se.aten.domain.ReceiptProduct;
import se.aten.domain.User;
import se.aten.repository.ReceiptRepository;
import se.aten.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for checkout
 */
@Service("checkoutService")
public class CheckoutServiceProductionImpl implements CheckoutService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    ReceiptRepository receiptRepository;

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
        Receipt receipt = new Receipt(total);
        receipt.setUser(user);
        List<ReceiptProduct> receiptProducts = new ArrayList<>();
        Map<Product, Integer> productMap = new HashMap<>();
        for(Product product : products) {
            if(!productMap.containsKey(product)) {
                productMap.put(product, 1);
            } else {
                for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
                    if(entry.getKey().equals(product)) {
                        entry.setValue(entry.getValue()+1);
                    }
                }
            }
        }
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            receiptProducts.add(new ReceiptProduct(entry.getKey(), entry.getValue()));
        }
        receipt.setProducts(receiptProducts);
        receiptRepository.save(receipt);
        user.addReceipt(receipt);
    }
}
