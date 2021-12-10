package com.projetofinal.sistemabibliotecario.repositories;

import com.projetofinal.sistemabibliotecario.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
