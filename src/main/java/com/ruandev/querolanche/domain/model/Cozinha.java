package com.ruandev.querolanche.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cozinha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cozinha cozinha = (Cozinha) o;
		return Objects.equals(id, cozinha.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}