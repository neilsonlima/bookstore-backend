package com.powerminas.bookstore.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "categorias")
public class Categoria {
	private Long id;
	private String nome;
	private String descricao;
	private List<Livro> livros = new ArrayList<>();

	public Categoria() {
		super();
	}

	public Categoria(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "NOME da categoria não pode ser vazio!")
	@Length(min = 3, max = 100, message = "O campo NOME precisa ter entre 3 e 100 caracteres!")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Descrição da categoria não pode ser vazia!")
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO precisa ter entre 3 e 100 caracteres!")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(mappedBy = "categoria")
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}
