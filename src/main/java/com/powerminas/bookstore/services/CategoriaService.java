package com.powerminas.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerminas.bookstore.dtos.CategoriaDTO;
import com.powerminas.bookstore.models.Categoria;
import com.powerminas.bookstore.repositories.CategoriaRepository;
import com.powerminas.bookstore.services.exceptions.DataIntegrityViolationException;
import com.powerminas.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findbyId(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada: " + id + " Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Long id, CategoriaDTO obj) {
		Categoria atual = findbyId(id);
		atual.setDescricao(obj.getDescricao());
		atual.setNome(obj.getNome());
		return repository.save(atual);
	}

	public void delete(Long id) {
		findbyId(id);
		try {

			repository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {

			throw new DataIntegrityViolationException("Categoira não pode ser removida por conter livros.");
		}
	}

}
