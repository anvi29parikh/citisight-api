package com.citysight.security.filter;

import com.citysight.security.exceptions.CustomSecurityException;
import com.citysight.security.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    @Value("${IS_PROXY:false}")
    private boolean isProxy;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String authorizationHeader = request.getHeader("Authorization");
            String token = null;
            //check header for token
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                token = authorizationHeader.substring(7);
                if (jwtUtil.validateToken(token)) {
                    Authentication auth = jwtUtil.getAuthentication(token);
                    SecurityContextHolder.getContext().setAuthentication(auth);

                    //set new header with new token
                    if(this.isProxy){
                        setHeader(response, jwtUtil.createNewToken(token));
                    }
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            response.sendError(HttpServletResponse.SC_CONFLICT, e.getMessage());
            throw new CustomSecurityException("INVALID TOKEN", HttpStatus.UNAUTHORIZED);
        }


        //continue the filter
        filterChain.doFilter(request, response);
    }

    private void setHeader(HttpServletResponse response, String newToken) {
        response.setHeader("Authorization", newToken);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.setHeader("trace-id", MDC.get("traceId"));
    }
}
