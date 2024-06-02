package com.bookmyshow.Service;

import com.bookmyshow.Model.mailStructure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class mailService {

    private JavaMailSender javaMailSender;

    @Value("$(spring.mail.username)")
    private String fromMail;

    mailService(JavaMailSender javaMailSender){
    this.javaMailSender=javaMailSender;
    }
    public void sendMail(String mail, mailStructure mailStructure){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mailStructure.getSubject());
        simpleMailMessage.setText(mailStructure.getMessage());
        simpleMailMessage.setTo(mail);

        javaMailSender.send(simpleMailMessage);
    }
}
