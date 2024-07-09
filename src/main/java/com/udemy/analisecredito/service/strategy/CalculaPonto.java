package com.udemy.analisecredito.service.strategy;

import com.udemy.analisecredito.domain.Proposta;

public interface CalculaPonto {

    int calcular(Proposta proposta);
}
