package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.aten.domain.Product;

@Repository
public interface ArticleRepository extends JpaRepository<Product, Long> {
}
