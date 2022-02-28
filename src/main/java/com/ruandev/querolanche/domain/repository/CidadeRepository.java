package com.ruandev.querolanche.domain.repository;

import com.ruandev.querolanche.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
