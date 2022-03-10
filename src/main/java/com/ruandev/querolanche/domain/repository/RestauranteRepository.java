package com.ruandev.querolanche.domain.repository;


import com.ruandev.querolanche.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>,
                                                    RestauranteRepositoryQueries {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    //@Query("from Restaurante where nome Like %:nome% and cozinha.id = :id")
    List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);

    //List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

    Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    int countByCozinhaId(Long cozinhaId);

}
