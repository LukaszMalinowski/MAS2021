package pl.lukaszmalina.mas2021.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.lukaszmalina.mas2021.model.Garage;
import pl.lukaszmalina.mas2021.model.TokenResponse;
import pl.lukaszmalina.mas2021.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtUtil {

    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String ROLE = "role";
    public static final String ID = "id";
    public static final String GARAGE_ID = "garageId";

    @Value ("${authentication.jwt.secret}")
    private String secret;

    public TokenResponse createToken(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        Date expiresDate = calendar.getTime();

        String jwt = JWT.create()
                        .withClaim(ID, user.getId())
                        .withClaim(GARAGE_ID, user.getGarage() == null ? -1L : user.getGarage().getId())
                        .withClaim(EMAIL, user.getEmail())
                        .withClaim(ROLE, user.getRole().getAuthority())
                        .withClaim(NAME, user.getFirstName())
                        .withIssuedAt(new Date())
                        .withExpiresAt(expiresDate)
                        .sign(Algorithm.HMAC512(secret));

        return new TokenResponse(jwt);
    }

}
