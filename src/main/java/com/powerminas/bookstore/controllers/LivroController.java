package com.powerminas.bookstore.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.powerminas.bookstore.dtos.LivroDTO;
import com.powerminas.bookstore.models.Livro;
import com.powerminas.bookstore.services.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(
			@RequestParam(value = "categoria", defaultValue = "0") Long categoria_id) {
		List<Livro> list = service.findAll(categoria_id);
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@Valid @PathVariable Long id, @RequestBody Livro obj) {
		Livro novo = service.update(id, obj);
		return ResponseEntity.ok().body(new LivroDTO(novo));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Long categoria_id,
			@Valid @RequestBody Livro obj) {
		Livro novo = service.create(categoria_id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(novo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
