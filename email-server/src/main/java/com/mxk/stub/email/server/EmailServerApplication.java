package com.mxk.stub.email.server;

import com.mxk.stub.email.server.factory.EmailMessageHandlerFactory;
import org.subethamail.smtp.server.SMTPServer;

public class EmailServerApplication {

    public static void main(String[] args) {
        EmailMessageHandlerFactory myFactory = new EmailMessageHandlerFactory() ;
        SMTPServer smtpServer = new SMTPServer(myFactory);
        smtpServer.setPort(25000);
        smtpServer.start();
    }
}
