package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.aten.domain.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
