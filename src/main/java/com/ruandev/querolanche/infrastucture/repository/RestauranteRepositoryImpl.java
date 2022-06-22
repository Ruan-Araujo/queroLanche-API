package com.ruandev.querolanche.infrastucture.repository;

import com.ruandev.querolanche.domain.model.Restaurante;
import com.ruandev.querolanche.domain.repository.RestauranteRepository;
import com.ruandev.querolanche.domain.repository.RestauranteRepositoryQueries;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.ruandev.querolanche.infrastucture.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.ruandev.querolanche.infrastucture.repository.spec.RestauranteSpecs.comNomeSemelhante;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
    //Implementando um repositório customizado

    @PersistenceContext
    private EntityManager manager;

    //Corrige a exceção de dependência circular
    //Quando a gente nao coloca o lazy, quando a classe impl é
    // instanciada pelo container do spring ela ve as dependencias que precisa
    // e instancia as dependencias
    //Mas como a dependência é um restaurante repository e um repository vai instanciar um impl
    // Ai fica na dependência circular
    // Quando colocamos lazy estamos dizendo só instancia essa
    // dependência no momento que for preciso
    @Autowired @Lazy
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> consultar(String nome, BigDecimal taxaFreteInicial,
                                  BigDecimal taxaFreteFinal ) {

        // FUnciona como uma fábrica para construir elementos
        // que precisamos para fazer consultas como os
        // criterios da consulta e a própria criteria query
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        // Retorna uma instância de uma criteriaquery de restaurante
        // O criteria query é um construtor de cláusulas
        CriteriaQuery<Restaurante> criteriaQuery = builder
                                                    .createQuery(Restaurante.class);

        // "from Restaurante - jpql"
        // representa que a raiz do from é o objeto Restaurante
        Root<Restaurante> root = criteriaQuery.from(Restaurante.class);

        // Lógica para tornar a consulta dinâmica utilizando lista
        var predicates = new ArrayList<Predicate>();

        //Devemos verificar as váriveis que iremos receber como parametros
        // e então adicionar as instancias de Predicate na lista.
        if (StringUtils.hasText(nome)) {
            predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
        }

        if (taxaFreteInicial != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        }

        if (taxaFreteFinal != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        }

        // Essa consulta busca por nome
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        // Passando um criteriaQuery retorna um TypedQuery
        TypedQuery<Restaurante> query =
                                manager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public List<Restaurante> findComFreteGratis(String nome) {
        return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
    }
}
