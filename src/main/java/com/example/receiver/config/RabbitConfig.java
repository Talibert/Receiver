package com.example.receiver.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String MY_QUEUE = "my-queue";

    @Bean
    public Queue myQueue() {
        return new Queue(MY_QUEUE, true);
    }
}
