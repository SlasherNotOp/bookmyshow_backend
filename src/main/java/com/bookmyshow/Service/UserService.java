package com.bookmyshow.Service;

import com.bookmyshow.Model.User;
import com.bookmyshow.Model.mailStructure;
import com.bookmyshow.Model.validUser;
import com.bookmyshow.configuration.configMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder, InMemoryUserDetailsManager inMemoryUserDetailsManager,RandomService randomService) {
        this.passwordEncoder = passwordEncoder;
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
        this.randomService=randomService;
    }

    private List<User> list=new ArrayList<>();
    InMemoryUserDetailsManager inMemoryUserDetailsManager;

    RandomService randomService;

    @Autowired
    mailService mailService;

    @Autowired
    configMail mail;
    public String addUser(User user){

        user.setOpt(randomService.generateRandomNumber());
        list.add(user);

        mailStructure mailStructure=mail.mail();
        mailStructure.setMessage(mailStructure.getMessage()+user.getOpt());

//        System.out.println("message is=>"+mailStructure.getMessage()+"subject is this=>"+mailStructure.getSubject());

        mailService.sendMail(
                user.getUserEmailId(),mailStructure
        );


        return "otp send successfully";


//        UserDetails user1= org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUserEmailId())
//                .password(passwordEncoder.encode(user.getUserPassword()))
//                .roles("user")
//                .build();
//        inMemoryUserDetailsManager.createUser(user1);
    }



    public void createUserByUserDetailsClass(validUser user){
        UserDetails userDetails= org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUserEmailId())
                .password(passwordEncoder.encode(user.getUserPassword()))
                .roles("user")
                .build();
        inMemoryUserDetailsManager.createUser(userDetails);
    }

    public String addUserWithOtp(User user) {

        if(list.contains(user)){
            validUser user1=new validUser();
            user1.setUserEmailId(user.getUserEmailId());
            user1.setUserPassword(user.getUserPassword());
            createUserByUserDetailsClass(user1);


            return "valid otp";
        }
        return "not valid";
    }
}
