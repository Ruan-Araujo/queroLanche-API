package com.ruandev.querolanche.domain.repository;

import com.ruandev.querolanche.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
