package com.ramiro.demoactivemq.controller;

import java.io.Serializable;

public record HomeRequestDto (String message) {

    public MessageDto toMessage(){
        return new MessageDto(this.message);
    }

    @Override
    public String toString() {
        return "HomeRequestDto{" +
                "mensagem='" + this.message + '\'' +
                '}';
    }
}
