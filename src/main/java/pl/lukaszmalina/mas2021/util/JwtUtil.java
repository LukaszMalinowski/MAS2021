package pl.lukaszmalina.mas2021.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.lukaszmalina.mas2021.model.TokenResponse;
import pl.lukaszmalina.mas2021.model.User;

import java.util.Calendar;
import java.util.Date;

@Component
public class JwtUtil {

    public static final String EMAIL = "email";

    @Value ("${authentication.jwt.secret}")
    private String secret;

    public TokenResponse createToken(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        Date expiresDate = calendar.getTime();

        String jwt = JWT.create()
                        .withClaim(EMAIL, user.getEmail())
                        .withIssuedAt(new Date())
                        .withExpiresAt(expiresDate)
                        .sign(Algorithm.HMAC512(secret));

        return new TokenResponse(jwt);
    }

}
