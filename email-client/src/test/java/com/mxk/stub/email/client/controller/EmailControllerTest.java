package com.mxk.stub.email.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxk.stub.email.client.model.EmailNotification;
import com.mxk.stub.email.client.repository.EmailRepository;
import com.mxk.stub.email.client.repository.entity.Email;
import com.mxk.stub.email.client.service.EmailNotificationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmailControllerTest {

    @InjectMocks
    private EmailController emailController;

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private EmailNotificationService emailNotificationService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(emailController).build();
    }

    @Test
    public void testGetEmails() throws Exception {
        List<Email> emailList = new ArrayList<Email>();
        emailList.add(new Email("content"));
        when(emailRepository.findAll()).thenReturn(emailList);

        MvcResult mvcResult = mockMvc.perform(get("/emails")).andExpect(status().isOk()).andReturn();
        String actual = mvcResult.getResponse().getContentAsString();
        String expected = "[{\"id\":null,\"content\":\"content\"}]";
        assertEquals(expected, actual);
        verify(emailRepository, times(1)).findAll();
    }

    @Test
    public void testSendEmail() throws Exception {
        EmailNotification email = new EmailNotification("send@example.com", "subject", "text");
        ObjectMapper mapper = new ObjectMapper();
        String emailAsJson = mapper.writeValueAsString(email);

        mockMvc.perform(post("/email").content(emailAsJson).contentType(contentType)).andExpect(status().isOk());
        verify(emailNotificationService, times(1)).sendNotification(any(EmailNotification.class));
    }

    protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
}