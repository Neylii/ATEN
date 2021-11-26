package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.aten.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
