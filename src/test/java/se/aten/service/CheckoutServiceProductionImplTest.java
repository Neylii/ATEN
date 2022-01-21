package se.aten.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import se.aten.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutServiceProductionImplTest {
    private CheckoutServiceProductionImpl checkout = new CheckoutServiceProductionImpl();
    private static List<Product> products = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        products.add(new Console("Test", "Test", 1000, ConsoleType.GAMECUBE, "Test"));
        products.add(new Console("Test", "Test", 500, ConsoleType.GAMECUBE, "Test"));
    }

    @Test
    public void calculateTotalPriceTest() {
        assertEquals(1500, checkout.calculateTotalPrice(products), "Expected price does not match the actual price");
    }

    @Test
    public void createNewReceiptTest() {
        User user = new User("BosseTheMan", "Apelem", "Bosse", "Bus", new UserAddress("Hampgränd 1", "12345", "Melbourne", "Australia", "123456789"));
        Receipt receipt = new Receipt(100);
        assertNotEquals(1, user.getUserReceipts().size(), "There should be 0 receipts since nothing has been added.");

        user.addReceipt(receipt);
        assertEquals(1, user.getUserReceipts().size(), "User should have 1 receipt.");
    }
}
