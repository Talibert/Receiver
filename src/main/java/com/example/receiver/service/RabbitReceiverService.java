package com.example.receiver.service;

import com.example.receiver.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Essa service vai escutar as mensagens distribuídas pelo RabbitMQ
 */
@Service
public class RabbitReceiverService {

    /**
     * Vai assinar a lista MY_QUEUE
     * @param mensagem
     */
    @RabbitListener(queues = RabbitConfig.MY_QUEUE)
    public void receiveMessage(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}
