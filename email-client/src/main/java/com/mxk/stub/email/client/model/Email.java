package com.mxk.stub.email.client.model;

public class Email {

    private String header;
    private String body;

    public Email(String header, String body) {
        this.header = header;
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }
}
