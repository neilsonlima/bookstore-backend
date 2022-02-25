package com.powerminas.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerminas.bookstore.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
