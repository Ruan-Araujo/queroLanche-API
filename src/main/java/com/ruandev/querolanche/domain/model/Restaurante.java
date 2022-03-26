package com.ruandev.querolanche.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "taxa_frete", nullable = false )//não aceita nulo
    private BigDecimal taxaFrete;

    //@JsonIgnore
    @JsonIgnoreProperties("hibernateLazyInitializer")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cozinha_id", nullable = false)
    private Cozinha cozinha;

    // Aqui indicamos que essa propriedade é uma classe do tipo incorporado,
    // Ela é uma parte da classe restaurante
    @JsonIgnore
    @Embedded
    private Endereco endereco;

    //Anotaçao da implementação do hibernate
    // Deve ser atribuida como uma data-hora atual no momento que a entidade
    // for salva pela primeira vez
    @JsonIgnore
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    // Informa que a data e hora atual deve ser atribuida a propriedade
    // sempre que a entidade for atualizada
    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "dateTime")
    private LocalDateTime dataAtualizacao;

    //@JsonIgnore
    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento",
              joinColumns = @JoinColumn(name = "restaurante_id"),
              inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    // Não é interessante retornar todas as formas de pagamento no collection resouce
    // Melhor retornar no singleton resource

    @JsonIgnore
    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos = new ArrayList<>();

}
