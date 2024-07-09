package com.udemy.analisecredito.service.strategy.impl;

import com.udemy.analisecredito.domain.Proposta;
import com.udemy.analisecredito.service.strategy.CalculaPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamentoImpl implements CalculaPonto {

    @Override
    public int calcular(Proposta proposta) {
        return possuiEmprestimosEmAndamento() ? 0 : 67;
    }

    private boolean possuiEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }
}
