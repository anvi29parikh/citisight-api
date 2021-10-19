package com.citysight.security.config;

import com.citysight.security.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final JwtUtil jwtUtil;

    public WebSecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //disable cors
        http.cors();
        //disable csrf
        http.csrf().disable();
        //disable httpBasic
        http.httpBasic().disable();
        //allow these requests
        http.authorizeRequests().antMatchers(Stream.concat(Arrays.stream(publicApis()), Arrays.stream(publicAuthApis()))
                        .toArray(String[]::new)).permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("USER")
                //and authorize all others
                .anyRequest().authenticated();
        //apply filter
        http.apply(new JwtFilterConfigure(jwtUtil));
        //make session stateless
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    private String[] publicAuthApis() {
        return new String[]{"/**/login", "/**/register"};
    }

    private String[] publicApis() {
        return new String[]{"/**/publicAPI"};
    }
}
