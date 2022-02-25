package com.ruandev.querolanche.api.controller;

import com.ruandev.querolanche.domain.exception.EntidadeEmUsoException;
import com.ruandev.querolanche.domain.exception.EntidadeNaoEncontradaException;
import com.ruandev.querolanche.domain.model.Cidade;
import com.ruandev.querolanche.domain.repository.CidadeRepository;
import com.ruandev.querolanche.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cidadeService;

    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {

        Cidade cidade = cidadeRepository.buscar(cidadeId);

        if (cidade != null) {
            return ResponseEntity.ok(cidade);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {

        try {
            cidade = cidadeService.salvar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
        }
        catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> atualizar(@PathVariable Long cidadeId,
                                       @RequestBody Cidade cidade){
        try {
            Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);

            if (cidadeAtual != null) {
                BeanUtils.copyProperties(cidade, cidadeAtual, "id");

                cidadeAtual = cidadeService.salvar(cidadeAtual);

                return ResponseEntity.ok(cidadeAtual);
            }
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> deletar(@PathVariable Long cidadeId) {
        try {
            cidadeService.excluir(cidadeId);
            return ResponseEntity.noContent().build();
        }
        catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
