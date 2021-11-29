package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.aten.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
