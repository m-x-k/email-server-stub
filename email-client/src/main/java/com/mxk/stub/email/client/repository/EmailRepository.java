package com.mxk.stub.email.client.repository;

import com.mxk.stub.email.client.model.Email;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailRepository {

    private List<Email> emailList = new ArrayList<Email>();

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }
}
