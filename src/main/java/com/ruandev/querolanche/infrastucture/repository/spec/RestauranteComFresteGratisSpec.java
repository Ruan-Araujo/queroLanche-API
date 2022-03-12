package com.ruandev.querolanche.infrastucture.repository.spec;

import com.ruandev.querolanche.domain.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class RestauranteComFresteGratisSpec implements Specification<Restaurante> {

    private static final long serialVersionUID = 1l;

    @Override
    public Specification<Restaurante> and(Specification<Restaurante> other) {
        return Specification.super.and(other);
    }

    @Override
    public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query,
                                                    CriteriaBuilder criteriaBuilder) {

        return criteriaBuilder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
    }
    //Codigo que comunica diretamente com a API do jpa consideramos infraestrutura
}
