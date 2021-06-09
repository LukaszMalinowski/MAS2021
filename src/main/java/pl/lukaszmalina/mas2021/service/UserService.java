package pl.lukaszmalina.mas2021.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.UserDto;
import pl.lukaszmalina.mas2021.model.Role;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.repository.RoleRepository;
import pl.lukaszmalina.mas2021.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public boolean userExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

    @Transactional
    public void registerUser(UserDto userDto) {
        Role role = roleRepository.findById(1L).orElse(new Role(1L, "ROLE_USER"));

        User user = new User(
                0,
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getAddress(),
                null,
                role
        );

        userRepository.save(user);
    }
}
