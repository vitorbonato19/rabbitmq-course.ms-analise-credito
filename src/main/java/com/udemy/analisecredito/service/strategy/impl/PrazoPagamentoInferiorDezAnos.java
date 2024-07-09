package com.udemy.analisecredito.service.strategy.impl;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.service.strategy.CalculaPonto;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagamentoInferiorDezAnos implements CalculaPonto {

    @Override
    public int calcular(Proposta proposta) {
        return prazoPagamentoMenorDezAnos(proposta) ? 100 : 0;
    }

    private boolean prazoPagamentoMenorDezAnos(Proposta proposta) {
        return proposta.getPrazoPagamento() < 10;
    }
}
