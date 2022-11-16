package br.com.bibliotecamagica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecamagica.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
