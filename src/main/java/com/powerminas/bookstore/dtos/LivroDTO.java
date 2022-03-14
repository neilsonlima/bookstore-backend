package com.powerminas.bookstore.dtos;

import java.io.Serializable;

import com.powerminas.bookstore.models.Livro;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 7157470588523548150L;
	
	private Long id;
	private String titulo;

	public LivroDTO() {
	}

	public LivroDTO(Livro obj) {
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
