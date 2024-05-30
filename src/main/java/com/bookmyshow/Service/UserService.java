package com.bookmyshow.Service;

import com.bookmyshow.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder, InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.passwordEncoder = passwordEncoder;
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public void addUser(User user){
        UserDetails user1= org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(passwordEncoder.encode(user.getUserPassword()))
                .roles("user")
                .build();
        inMemoryUserDetailsManager.createUser(user1);
    }
}
