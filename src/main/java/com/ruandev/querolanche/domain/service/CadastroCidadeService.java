package com.ruandev.querolanche.domain.service;

import com.ruandev.querolanche.domain.exception.EntidadeEmUsoException;
import com.ruandev.querolanche.domain.exception.EntidadeNaoEncontradaException;
import com.ruandev.querolanche.domain.model.Cidade;
import com.ruandev.querolanche.domain.model.Estado;
import com.ruandev.querolanche.domain.repository.CidadeRepository;
import com.ruandev.querolanche.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {

        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de estado com código %d",
                                estadoId)));

        cidade.setEstado(estado);

        return cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com o código %d",
                            cidadeId)
            );
        }
        catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, " +
                            "pois está em uso", cidadeId)
            );
        }
    }
}
