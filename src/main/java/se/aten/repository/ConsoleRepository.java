package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.aten.domain.Console;
import se.aten.domain.ConsoleType;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
    List<Console> findByBrand(ConsoleType brand);
}