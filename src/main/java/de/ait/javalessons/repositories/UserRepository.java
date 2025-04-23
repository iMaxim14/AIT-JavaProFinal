package de.ait.javalessons.repositories;

import de.ait.javalessons.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findAllByUsernameAndPassword(String username, String password);
}
