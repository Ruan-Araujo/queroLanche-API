package com.ruandev.querolanche.domain.repository;


import com.ruandev.querolanche.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
