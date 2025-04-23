package de.ait.javalessons.service;

import de.ait.javalessons.model.User;
import de.ait.javalessons.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String rawPassword) {
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists " + username);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.getRoles().add("ROLE_USER");
        userRepository.save(user);
    }
}
