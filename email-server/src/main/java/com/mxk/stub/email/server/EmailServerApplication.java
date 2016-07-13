package com.mxk.stub.email.server;

import com.mongodb.MongoClient;
import com.mxk.stub.email.server.factory.EmailMessageHandlerFactory;
import org.subethamail.smtp.server.SMTPServer;

public class EmailServerApplication {

    public static void main(String[] args) throws Exception {
        MongoClient mongo = new MongoClient( "emailserverstub_email-db_1" , 27017 );
        EmailMessageHandlerFactory myFactory = new EmailMessageHandlerFactory(mongo) ;
        SMTPServer smtpServer = new SMTPServer(myFactory);
        smtpServer.setPort(25000);
        smtpServer.start();
    }
}
