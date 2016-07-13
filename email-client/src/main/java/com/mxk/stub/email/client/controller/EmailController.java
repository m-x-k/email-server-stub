package com.mxk.stub.email.client.controller;

import com.mxk.stub.email.client.model.Email;
import com.mxk.stub.email.client.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {

    @Autowired
    private EmailRepository emailRepository;

    @RequestMapping(value = "/emails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Email>> getEmails() {
        List<Email> emailList = emailRepository.findAll();
        return new ResponseEntity<List<Email>>(emailList, HttpStatus.OK);
    }

}
