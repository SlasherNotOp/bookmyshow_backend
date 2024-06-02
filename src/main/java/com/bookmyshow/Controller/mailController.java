package com.bookmyshow.Controller;

import com.bookmyshow.Model.mailStructure;
import com.bookmyshow.Service.mailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class mailController {
    private mailService mailService;
    mailController(mailService mailService){
        this.mailService=mailService;
    }
    @PostMapping("/send/{mail}")
    public String sendMail(@PathVariable String mail, @RequestBody mailStructure mailStructure){
        mailService.sendMail(mail,mailStructure);
        return  "send mail successfully";
    }
}
