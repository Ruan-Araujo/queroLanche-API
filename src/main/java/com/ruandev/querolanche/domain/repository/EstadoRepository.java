package com.ruandev.querolanche.domain.repository;

import com.ruandev.querolanche.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
