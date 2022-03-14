package com.powerminas.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.powerminas.bookstore.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :categoria_id ORDER BY titulo")
	List<Livro> findAllBuyCategoria(@Param(value = "categoria_id") Long categoria_id);

}
