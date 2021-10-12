package com.citysight.security.util;


import com.citysight.security.enums.EnvironmentApiKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtUtil {

    final int expiryTime = 360000;
    private String salt;


    @Value("${ENVIRONMENT}")
    private String environment;

    @PostConstruct
    protected void init() {
        this.salt = EnvironmentApiKey.valueOf(this.environment).getValue();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractRole(String token) {
        return (String) Jwts.parser().setSigningKey(salt).parseClaimsJws(token).getBody().get("Role");
    }

//    public Date extractRoleName(String token) {
//        return extractClaim(token, Claims::);
//    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(salt).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username, String roleName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("Role", roleName);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiryTime))
                .signWith(SignatureAlgorithm.HS256, salt).compact();
    }

    public boolean validateToken(String token) {
        if (!isTokenExpired(token)) {
            Jwts.parser().setSigningKey(salt).parseClaimsJws(token);
            return true;
        }
        return false;
    }

    public String createNewToken(String token) {
        String userName = extractUsername(token);
        String roleName = extractRole(token);
        return generateToken(userName, roleName);
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String token) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(extractRole(token));
        return Collections.singletonList(authority);
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = new User(extractUsername(token), extractUsername(token),
                true, false, false, false,
                getAuthorities(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
