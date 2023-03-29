package com.example.redissecurityjwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.redissecurityjwt.user.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.UUID;

/**
 * packageName : com.example.redissecurityjwt.config
 * fileName : JwtUtil
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */
public class JwtUtil {

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(String.valueOf(UUID.randomUUID()));
    private static final long AUTH_TIME = 30 * 60;

    public static String makeAuthToken(UserDetails details) {
        return JWT.create().withSubject(details.getUsername())
                .withClaim("exp", Instant.now().getEpochSecond() + AUTH_TIME)
                .withClaim("userEmail", details.getUsername())
                .sign(ALGORITHM);
    }

    public static VerifyResult verify(String token) {
        try {
            DecodedJWT verify =  JWT.require(ALGORITHM).build().verify(token);
            return VerifyResult.builder()
                    .success(true)
                    .memberId(verify.getSubject())
                    .build();

        } catch (Exception e ) {
            DecodedJWT decoded = JWT.decode(token);
            return VerifyResult.builder()
                    .success(false)
                    .memberId(decoded.getSubject())
                    .build();
        }
    }
}