package providers;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken() {

        return "jwt_token";
    }

    public boolean validateToken(String token) {

        return true;
    }
}