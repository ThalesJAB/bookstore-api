package br.com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookstore.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
