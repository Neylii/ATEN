package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import se.aten.domain.Console;
import se.aten.domain.ConsoleType;


import java.util.List;

public interface ConsoleRepository extends JpaRepository<Console, Long> {
    List<Console> findByBrand(ConsoleType brand);
}
