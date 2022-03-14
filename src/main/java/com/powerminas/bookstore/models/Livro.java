package com.powerminas.bookstore.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "livros")
public class Livro {
	private Long id;
	private String titulo;
	private String autor;
	private String texto;
	private Categoria categoria;

	public Livro() {
	}

	public Livro(String titulo, String autor, String texto, Categoria categoria) {
		this.titulo = titulo;
		this.autor = autor;
		this.texto = texto;
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "TITULO do Livro não pode ser vazio!")
	@Length(min = 3, max = 100, message = "O campo TITULO precisa ter entre 3 e 100 caracteres!")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@NotEmpty(message = "NOME do AUTOR do Livro não pode ser vazio!")
	@Length(min = 3, max = 100, message = "O campo Nome precisa ter entre 3 e 100 caracteres!")
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@NotEmpty(message = "TEXTO do Livro não pode ser vazio!")
	@Length(min = 10, max = 200000, message = "O campo TEXTO precisa ter entre 3 e 300 caracteres!")
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", texto=" + texto + "]";
	}

}
