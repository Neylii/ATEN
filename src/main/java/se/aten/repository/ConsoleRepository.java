package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import se.aten.domain.Console;

public interface ConsoleRepository extends JpaRepository<Console, Long> {
}
