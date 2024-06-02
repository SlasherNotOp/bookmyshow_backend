package com.bookmyshow.configuration;

import com.bookmyshow.Model.mailStructure;
import org.springframework.stereotype.Service;

@Service
public class configMail {
    public mailStructure mail(){
        mailStructure mailStructure=new mailStructure();
        mailStructure.setSubject("this mail regarding your login");
        mailStructure.setMessage("the opt is ");

        return mailStructure;
    }
}
