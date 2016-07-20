package com.mxk.stub.email.client.service;

import com.mxk.stub.email.client.model.EmailNotification;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class EmailNotificationServiceTest {

    @InjectMocks
    private EmailNotificationService emailNotificationService;

    @Mock
    private JavaMailSender javaMailSender;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendNotification() throws Exception {
        EmailNotification emailNotification = new EmailNotification("send@example.com", "subject", "content");
        emailNotificationService.sendNotification(emailNotification);
        verify(javaMailSender).send(any(SimpleMailMessage.class));
    }
}