package com.udemy.analisecredito.service.strategy.impl;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.service.strategy.CalculaPonto;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorQueValorSolicitado implements CalculaPonto {


    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorQueValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean rendaMaiorQueValorSolicitado(Proposta proposta) {
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }
}
