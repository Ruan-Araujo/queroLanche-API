package com.ruandev.querolanche.infra.repository;

import com.ruandev.querolanche.domain.model.Restaurante;
import com.ruandev.querolanche.domain.repository.RestauranteRepositoryQueries;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
    //Implementando um repositório customizado

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> consultar(String nome, BigDecimal taxaFreteInicial,
                                  BigDecimal taxaFreteFinal ) {

        var jpql = "from Restaurante where nome like :nome and taxaFrete between " +
                ":taxaInicial and :taxaFinal";

        return manager.createQuery(jpql, Restaurante.class)
                                .setParameter("nome", "%" + nome + "%")
                                .setParameter("taxaInicial", taxaFreteInicial)
                                .setParameter("taxaFinal", taxaFreteFinal)
                                .getResultList();
    }
}
