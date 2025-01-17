package com.udemy.analisecredito.service.strategy.impl;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.exceptions.StrategyException;
import com.udemy.analisecredito.mensagens.MensagensDefault;
import com.udemy.analisecredito.service.strategy.CalculaPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculaPonto {

    @Override
    public int calcular(Proposta proposta) {
        if (nomeNegativado()) {
            throw new StrategyException(String.format(MensagensDefault.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));
        }
        return 100;
    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }
}
