package com.projetofinal.sistemabibliotecario.repositories;

import com.projetofinal.sistemabibliotecario.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
