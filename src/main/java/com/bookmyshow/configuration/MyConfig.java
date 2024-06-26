package com.bookmyshow.configuration;

import lombok.Builder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Builder
public class MyConfig {

    @Bean
    public InMemoryUserDetailsManager setUpUsers(){
        UserDetails userDetails= User.builder()
                .username("MOHIT")
                .password(passwordEncoder().encode("MOHIT"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager((userDetails));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(customizer->
                customizer.requestMatchers("/user/**").permitAll()
                        .anyRequest().authenticated()

                ).httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .csrf(g -> g.disable());

        return  httpSecurity.build();
    }

}
