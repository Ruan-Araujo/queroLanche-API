package com.ruandev.querolanche.infrastucture.repository.spec;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class RestauranteComNomeSemelhanteSpec implements Specification {

    private static final long serialVersionUID = 1l;
    private String nome;

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query,
                                 CriteriaBuilder criteriaBuilder) {

        return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

}
