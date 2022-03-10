package com.ruandev.querolanche.domain.repository;

import com.ruandev.querolanche.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepositoryQueries {
    List<Restaurante> consultar(String nome, BigDecimal taxaFreteInicial,
                                BigDecimal taxaFreteFinal );
}
