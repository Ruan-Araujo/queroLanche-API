package com.ruandev.querolanche.domain.repository;


import com.ruandev.querolanche.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Long id);

}
