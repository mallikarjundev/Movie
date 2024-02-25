package com.movieapp.UserService.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieapp.UserService.dto.UserAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class Producer {
    @Value("${topic.name}")
    private String userTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendData(UserAuth userAuth) throws JsonProcessingException {
        String userData = objectMapper.writeValueAsString(userAuth);
        kafkaTemplate.send(userTopic, userData);
        return "Data sent from producer";
    }
}
