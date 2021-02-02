package com.example.demo;

import java.io.IOException;


import com.example.demo.Model;
import com.example.demo.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import com.example.demo.MessageRepository;
@SuppressWarnings("unused")
@Service

public class Consumer   {
	@Autowired
	MessageRepository messageRepository;
	
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    String msg;
    
    @KafkaListener(topics = "users-2", groupId = "group_id")
    public void consume(String message) throws IOException {
    	msg=message;
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
    
    public void save()
    {
    	Model m=new Model(msg);
    	   logger.info("Storing message in the database");
    	messageRepository.save(m);
    }
    
}
