package com.ramiro.demoactivemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    private Logger log = LoggerFactory.getLogger(HomeController.class);

    private final JmsTemplate jmsTemplate;

    public HomeController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/publish_message")
    public ResponseEntity<HomeResponseDto> publishMessage(@RequestBody HomeRequestDto message) {
        jmsTemplate.convertAndSend("home_queue", message.toMessage());
        return ResponseEntity.ok(new HomeResponseDto("mensagem publicada com sucesso."));

    }
}
