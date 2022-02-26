package com.powerminas.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerminas.bookstore.models.Categoria;
import com.powerminas.bookstore.models.Livro;
import com.powerminas.bookstore.repositories.CategoriaRepository;
import com.powerminas.bookstore.repositories.LivroRepository;

@Service
public class PopularBase {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void popular() {
		Categoria categoria1 = new Categoria("Java", "Livro de Java ");
		Categoria categoria2 = new Categoria("PHP", "Livro de PHP");
		
		Livro livro1 = new Livro("Livro de Java Básico", "Java Básico", "Lorem ipsum", categoria1);
		Livro livro2 = new Livro("Livro de Java Intermediário", "Java Intermediário", "Lorem ipsum", categoria1);
		Livro livro3 = new Livro("Livro de Java Avançado", "Java Avançado", "Lorem ipsum", categoria1);
		
		Livro livro4 = new Livro("Livro de PHP Básico", "Java Básico", "Lorem ipsum", categoria2);
		Livro livro5 = new Livro("Livro de PHP Intermediário", "Java Intermediário", "Lorem ipsum", categoria2);
		
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
	}
}
