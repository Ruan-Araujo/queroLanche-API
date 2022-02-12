package com.ruandev.querolanche.domain.repository;


import com.ruandev.querolanche.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> todos();
    Restaurante porId(Long id);
    Restaurante adicionar(Restaurante restaurante);
    void remover(Restaurante restaurante);

}
