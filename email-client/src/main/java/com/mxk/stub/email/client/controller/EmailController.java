package com.mxk.stub.email.client.controller;

import com.mxk.stub.email.client.model.Email;
import com.mxk.stub.email.client.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailRepository emailRepository;

    public @ResponseBody ResponseEntity<List<Email>> getEmails() {
        List<Email> emailList = emailRepository.getEmailList();
        return new ResponseEntity<List<Email>>(emailList, HttpStatus.OK);
    }

}
