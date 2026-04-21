package gameflix.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SecurityProperties.User, Long> {
    // Find user by username (for login)
    Optional<SecurityProperties.User> findByUsername(String username);

    // Optional: check if username already exists (for registration)
    boolean existsByUsername(String username);
}


