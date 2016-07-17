package com.mxk.stub.email.client.service;

import com.mxk.stub.email.client.model.EmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.send.from}")
    private String sendFrom;

    @Autowired
    public EmailNotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendNotification(EmailNotification email) throws MailException, InterruptedException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email.getSendTo());
        mail.setFrom(sendFrom);
        mail.setSubject(email.getSubject());
        mail.setText(email.getText());
        javaMailSender.send(mail);
    }

}
