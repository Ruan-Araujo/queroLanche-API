package com.ruandev.querolanche.domain.repository;

import com.ruandev.querolanche.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);

}
