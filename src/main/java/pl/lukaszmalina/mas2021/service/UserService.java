package pl.lukaszmalina.mas2021.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.UserDto;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean userExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

    @Transactional
    public User registerUser(UserDto userDto) {
        User user = new User(
                0,
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getAddress(),
                null
        );

        return userRepository.save(user);
    }
}
