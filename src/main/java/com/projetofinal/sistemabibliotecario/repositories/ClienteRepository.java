package com.projetofinal.sistemabibliotecario.repositories;

import com.projetofinal.sistemabibliotecario.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
