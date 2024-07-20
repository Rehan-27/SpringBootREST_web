package rehan.spring.restwebservices.rehanrest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rehan.spring.restwebservices.rehanrest.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
}
