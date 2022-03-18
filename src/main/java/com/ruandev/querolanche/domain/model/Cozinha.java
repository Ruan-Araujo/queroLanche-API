package com.ruandev.querolanche.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@JsonIgnore
	//@JsonProperty("titulo")
	@Column(nullable = false)
	private String nome;

	//Sempre que aparecer a terminação many está indicando que é uma coleção.
	//Com esse atributo indicamos qual é o nome da propriedade inversa.
	// Estamaos dizendo onde em restaurante está a ligação com cozinha
	// Aqui o serializador da requisição json (jackson)
	// vai colocar uma lista de restaurantes em cozinha
	// Aqui temos o problema de referência circular novamente, um loop infinito.
	// Isso pode derrubar o servidor
	// A seguinte annotation resolve esse problema
	@JsonIgnore
	@OneToMany(mappedBy = "cozinha")
	private List<Restaurante> restaurantes = new ArrayList<>();
}
