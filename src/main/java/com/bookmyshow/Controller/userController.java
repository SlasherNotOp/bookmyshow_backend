package com.bookmyshow.Controller;

import com.bookmyshow.Model.User;
import com.bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        value = "http://localhost:3000/"
)
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){

       return userService.addUser(user);
    }

    @PostMapping("/addByOtp")
    public String addUserwithOtp(@RequestBody User user){
        return userService.addUserWithOtp(user);
    }
}
