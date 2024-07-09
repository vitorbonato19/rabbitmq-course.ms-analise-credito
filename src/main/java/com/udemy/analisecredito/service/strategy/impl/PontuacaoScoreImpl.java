package com.udemy.analisecredito.service.strategy.impl;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.exceptions.StrategyException;
import com.udemy.analisecredito.mensagens.MensagensDefault;
import com.udemy.analisecredito.service.strategy.CalculaPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PontuacaoScoreImpl implements CalculaPonto {

    @Override
    public int calcular(Proposta proposta) {
        int score = score();

        if (score < 200) {
            throw new StrategyException(String.format(MensagensDefault.SCORE_SERASA_BAIXO, proposta.getUsuario().getNome()));
        } else if (score <= 400) {
            return 210;
        } else if (score <= 600) {
            return 312;
        } else {
            return 500;
        }
    }

    private int score() {
        return new Random().nextInt(0, 1000);
    }
}
