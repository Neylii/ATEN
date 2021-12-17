package se.aten.service;

import se.aten.domain.Product;

import java.util.List;

public interface CheckoutService {

    public void checkout(long userId, List<Product> products);
}
