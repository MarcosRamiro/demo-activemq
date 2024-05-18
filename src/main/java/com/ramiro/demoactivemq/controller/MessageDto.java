package com.ramiro.demoactivemq.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record MessageDto(
        @JsonProperty("message") String message) {}
