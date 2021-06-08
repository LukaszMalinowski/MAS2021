package pl.lukaszmalina.mas2021.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszmalina.mas2021.dto.UserCredentials;
import pl.lukaszmalina.mas2021.model.TokenResponse;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.util.JwtUtil;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping ("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid UserCredentials userCredentials) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userCredentials.getEmail(), userCredentials.getPassword()
            ));

            User user = (User)authenticate.getPrincipal();
            return ResponseEntity.ok(jwtUtil.createToken(user));
        }
        catch (BadCredentialsException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
