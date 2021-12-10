package com.projetofinal.sistemabibliotecario.repositories;

import com.projetofinal.sistemabibliotecario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
