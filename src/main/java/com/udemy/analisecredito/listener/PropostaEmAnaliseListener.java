package com.udemy.analisecredito.listener;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.service.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
public class PropostaEmAnaliseListener {

    private final AnaliseCreditoService analiseCreditoService;

    public PropostaEmAnaliseListener(AnaliseCreditoService analiseCreditoService) {
        this.analiseCreditoService = analiseCreditoService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(Proposta proposta) {
        analiseCreditoService.analisar(proposta);
    }
}
