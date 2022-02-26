package com.powerminas.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerminas.bookstore.models.Categoria;
import com.powerminas.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findbyId(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
}
