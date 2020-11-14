package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JWTTest {
    public static void main(String[] args) {

        System.out.println(createAndSignToken());

    }

    private static String createAndSignToken() {

        String token = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256("my-secret");
            token = JWT.create()
                    .withClaim("Id","123456")
                    .sign(algorithm);
        } catch (JWTCreationException ex) {

            ex.printStackTrace();

        }

        return token;

    }

}
