package com.powerminas.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerminas.bookstore.models.Categoria;
import com.powerminas.bookstore.models.Livro;
import com.powerminas.bookstore.repositories.LivroRepository;
import com.powerminas.bookstore.services.exceptions.DataIntegrityViolationException;
import com.powerminas.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository respository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {
		Optional<Livro> obj = respository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Livro: " + id + " não encontrado. Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long categoria_id) {
		categoriaService.findbyId(categoria_id);
		return respository.findAllBuyCategoria(categoria_id);
	}

	public Livro update(Long id, Livro obj) {
		Livro atual = findById(id);
		updateDate(obj, atual);
		return respository.save(atual);
	}

	public void delete(Long id) {
		findById(id);
		try {
			respository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {

			throw new DataIntegrityViolationException("Livro não pode ser removido.");
		}

	}

	public Livro create(Long categoria_id, Livro obj) {
		Categoria categoria = categoriaService.findbyId(categoria_id);
		obj.setId(null);
		obj.setCategoria(categoria);
		return respository.save(obj);
	}

	private void updateDate(Livro obj, Livro atual) {
		atual.setAutor(obj.getAutor());
		atual.setTexto(obj.getTexto());
		atual.setTitulo(obj.getTitulo());
	}

}
