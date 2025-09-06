package com.example.receiver.service;

import com.example.receiver.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service para gerenciar recebimento e devolução de mensagens
 */
@Service
public class RabbitReceiverService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitReceiverService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Vai assinar a fila RESQUEST_QUEUE para receber mensagens do primeiro projeto
     * @param mensagem
     */
    @RabbitListener(queues = RabbitConfig.REQUEST_QUEUE)
    public void receiveMessage(String mensagem) {
        processaMensagemEDevolve(mensagem);
    }

    /**
     * Processa a mensagem e devolve através da fila RESPONSE_QUEUE para o primeiro projeto
     * @param mensagem
     */
    protected void processaMensagemEDevolve(String mensagem){
        String mensagemProcessada = mensagem.toUpperCase();

        rabbitTemplate.convertAndSend(RabbitConfig.RESPONSE_QUEUE, mensagemProcessada);
    }
}
