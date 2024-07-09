package com.udemy.analisecredito.service;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.exceptions.StrategyException;
import com.udemy.analisecredito.service.strategy.CalculaPonto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    private final List<CalculaPonto> calculaPontoList;

    private final NotificaRabbitMQService notificaRabbitMQService;

    private final String exchangePropostaConcluida;

    public AnaliseCreditoService(List<CalculaPonto> calculaPontoList,
                                 NotificaRabbitMQService notificaRabbitMQService,
                                 @Value("${rabbitmq.exchange.proposta.concluida}") String exchangePropostaConcluida) {
        this.calculaPontoList = calculaPontoList;
        this.notificaRabbitMQService = notificaRabbitMQService;
        this.exchangePropostaConcluida = exchangePropostaConcluida;
    }

    public void analisar(Proposta proposta) {

        try {
            var scoreTotal =
                    calculaPontoList.
                            stream().
                            mapToInt(impl -> impl.calcular(proposta)).
                            sum();
            proposta.setAprovada(scoreTotal > 350);

        } catch (StrategyException ex) {
            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());
        }
        notificaRabbitMQService.notificar(exchangePropostaConcluida, proposta);
    }
}
