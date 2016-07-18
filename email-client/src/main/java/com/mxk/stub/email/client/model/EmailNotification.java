package com.mxk.stub.email.client.model;

public class EmailNotification {

    private String sendTo;
    private String subject;
    private String text;

    protected EmailNotification() {
    }

    public EmailNotification(String sendTo, String subject, String text) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.text = text;
    }

    public String getSendTo() {
        return sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
