package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.aten.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
