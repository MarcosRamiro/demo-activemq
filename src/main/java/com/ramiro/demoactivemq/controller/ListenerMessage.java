package com.ramiro.demoactivemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerMessage {

    Logger log = LoggerFactory.getLogger(ListenerMessage.class);

    @JmsListener(destination = "home_queue", containerFactory = "myFactory")
    public void processMessage1(MessageDto message){
        log.info("#1 - mensagem recebida {}", message.message());
    }

    @JmsListener(destination = "home_queue", containerFactory = "myFactory")
    public void processMessage2(MessageDto message){
        log.info("#2 - mensagem recebida {}", message.message());
    }
}
