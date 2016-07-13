package com.mxk.stub.email.client.repository;

import com.mxk.stub.email.client.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmailRepository extends MongoRepository<Email, String> {

    List<Email> findAll();

}
