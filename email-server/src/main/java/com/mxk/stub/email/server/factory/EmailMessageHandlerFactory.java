package com.mxk.stub.email.server.factory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.subethamail.smtp.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EmailMessageHandlerFactory implements MessageHandlerFactory {

    private DBCollection emailCollection;

    public EmailMessageHandlerFactory(MongoClient mongo) {
        super();
        DB db = mongo.getDB("emails");
        emailCollection = db.getCollection("email");
    }

    public MessageHandler create(MessageContext ctx) {
        return new Handler(ctx);
    }

    class Handler implements MessageHandler {
        MessageContext ctx;

        public Handler(MessageContext ctx) {
            this.ctx = ctx;
        }

        public void from(String from) throws RejectException {
            System.out.println("FROM:" + from);
        }

        public void recipient(String recipient) throws RejectException {
            System.out.println("RECIPIENT:" + recipient);
        }

        public void data(InputStream data) throws IOException {
            String emailContent = this.convertStreamToString(data);

            System.out.println("MAIL DATA");
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.println(emailContent);
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");

            insertEmailIntoDB(emailContent);
        }

        public void done() {
            System.out.println("Finished");
        }

        public String convertStreamToString(InputStream is) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

    }

    private void insertEmailIntoDB(String emailContent) {
        BasicDBObject document = new BasicDBObject();
        document.put("content", emailContent);
        emailCollection.insert(document);
    }
}