package com.example.rabbitmqjmspublisher;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getMessage")
    public String get(@RequestParam String message){
        rabbitTemplate.convertAndSend("eggs",message);
        return "sent";
    }

}
