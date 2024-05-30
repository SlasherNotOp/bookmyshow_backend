package com.bookmyshow.Controller;

import com.bookmyshow.Model.User;
import com.bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user){

        userService.addUser(user);
    }
}
