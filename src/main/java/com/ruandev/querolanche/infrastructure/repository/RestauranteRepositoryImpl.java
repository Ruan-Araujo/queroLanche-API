package com.ruandev.querolanche.infrastructure.repository;

import com.ruandev.querolanche.domain.model.Restaurante;
import com.ruandev.querolanche.domain.repository.RestauranteRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> listar() {

        return manager.createQuery("from Restaurante", Restaurante.class)
                .getResultList();

    }

    @Override
    public Restaurante buscar(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Long restauranteId) {
        Restaurante restaurante = buscar(restauranteId);

        if (restaurante == null)
            throw new EmptyResultDataAccessException(1);

        manager.remove(restaurante);
    }
}
