package com.ruandev.querolanche.infrastructure.repository;

import com.ruandev.querolanche.domain.model.Restaurante;
import com.ruandev.querolanche.domain.repository.RestauranteRepository;
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
    public List<Restaurante> todos() {

        return manager.createQuery("from Restaurante", Restaurante.class)
                .getResultList();

    }

    @Override
    public Restaurante porId(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante adicionar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        restaurante = porId(restaurante.getId());
        manager.remove(restaurante);
    }
}
