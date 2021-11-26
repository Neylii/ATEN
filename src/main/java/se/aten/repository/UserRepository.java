package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.aten.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
