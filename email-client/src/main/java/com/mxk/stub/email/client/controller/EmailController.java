package com.mxk.stub.email.client.controller;

import com.mxk.stub.email.client.model.EmailNotification;
import com.mxk.stub.email.client.repository.entity.Email;
import com.mxk.stub.email.client.repository.EmailRepository;
import com.mxk.stub.email.client.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailController {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailNotificationService emailNotificationService;

    @RequestMapping(value = "/emails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Email>> getEmails() {
        List<Email> emailList = emailRepository.findAll();
        return new ResponseEntity<List<Email>>(emailList, HttpStatus.OK);
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> sendEmail(@RequestBody EmailNotification emailNotification) throws InterruptedException {
        emailNotificationService.sendNotification(emailNotification);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}
