package com.multi.pratice.multipratice;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.ToString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * packageName : com.multi.pratice.multipratice
 * fileName : JWTSimpleTest
 * author : taeil
 * date : 2023/03/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/17        taeil                   최초생성
 */
public class JWTSimpleTest {

    private void printToken(String token) {
        String[] tokens = token.split("\\.");
        // header --> alg
        System.out.println("header: " + new String(Base64.getDecoder().decode(tokens[0])));
        // body --> payload
        System.out.println("body: " + new String(Base64.getDecoder().decode(tokens[1])));
    }

    @DisplayName("1. jjwt 이용한 토큰 테스트")
    @Test
    void test_1() {
        String okta_token = Jwts.builder().addClaims(
                Map.of("name", "tail", "age", 29)
                )
                .signWith(SignatureAlgorithm.HS256, "taeil") // -> sign은 알고리즘과 키값
                .compact();
        System.out.println(okta_token);
        printToken(okta_token);
        // eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGFpbCIsImFnZSI6Mjl9.XuD46xUgTiB2meb2XSStZGsUi4DMxpo1AmVt5sYNy6o
        //   header                    body                        헤더와 바디를 서명한 hash 값

        Jws<Claims> tokenInfo = Jwts.parser().setSigningKey("taeil").parseClaimsJws(okta_token);
        System.out.println(tokenInfo);


    }

    @DisplayName("2. java-jwt를 이용한 토큰 테스트")
    @Test
    void test_2() {

        byte[] SEC_KEY = DatatypeConverter.parseBase64Binary("taeil");



        String oauth0_token = JWT.create().
                withClaim("name", "taeil")
                .withClaim("age", 5000)
                .sign(Algorithm.HMAC256("taeil"));

        System.out.println(oauth0_token);
        printToken(oauth0_token);

        // SEC_KEY값을 Base64로 맞춘다면, 라이브러리에 상관없이 Decode가 가능함
        // 맞춰줘야 하는 이유는 라이브러리마다 secret_key에 대한 관리가 다르기 때문임
        // 즉, 알고리즘과 secret key값만 맞다면 모두 사용할수있음.
        DecodedJWT verified = JWT.require(
                Algorithm.HMAC256(SEC_KEY))
                .build()
                .verify(oauth0_token);

        Jws<Claims> tokenInfo = Jwts.parser()
                .setSigningKey(SEC_KEY)
                .parseClaimsJws(oauth0_token);

        System.out.println(tokenInfo);
        System.out.println(verified.getClaims());

    }

    @DisplayName("3. 만료 시간 테스트")
    @Test
    void test_3 () throws InterruptedException {
        final Algorithm AL = Algorithm.HMAC256("taeil");


        String token =JWT.create()
                         .withSubject("taeil")
                         // --> 토큰 발급 후 1초가 지난 후 부터 유효하게 설정, 바로 사용하려고 하면 InvalidClaimException
                         .withNotBefore(new Date(System.currentTimeMillis() + 1000))
                         .withExpiresAt(new Date(System.currentTimeMillis() + 3000)) // --> 유효시간 1초
                         .sign(AL);

        try {
            // Thread.sleep(2000);  // --> expiresAt이 1000인 경우에 toekn expired Exception
            DecodedJWT verify = JWT.require(AL).build().verify(token);
            System.out.println(verify.getClaims());
            System.out.println("유효한 토큰입니다");
        } catch (Exception e) {
            // 에러가 발생하더라도 토큰 내용 까보기
            System.out.println("유효하지 않은 토큰입니다");
            System.out.println("e >>> " +  e.getClass().getSimpleName());

            DecodedJWT decode = JWT.decode(token);
            System.out.println(decode.getClaims());

        }
    }





} // class end