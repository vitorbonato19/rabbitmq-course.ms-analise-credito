package com.udemy.analisecredito.service;

import com.udemy.analisecredito.domain.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificaRabbitMQService {

    private RabbitTemplate rabbitTemplate;

    public NotificaRabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void notificar(String exchange, Proposta proposta) {
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
