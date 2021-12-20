package com.projetofinal.sistemabibliotecario.services;

import com.projetofinal.sistemabibliotecario.domain.Cliente;
import com.projetofinal.sistemabibliotecario.domain.Emprestimo;
import com.projetofinal.sistemabibliotecario.domain.Livro;
import com.projetofinal.sistemabibliotecario.domain.Usuario;
import com.projetofinal.sistemabibliotecario.domain.enums.Perfil;
import com.projetofinal.sistemabibliotecario.repositories.ClienteRepository;
import com.projetofinal.sistemabibliotecario.repositories.EmprestimoRepository;
import com.projetofinal.sistemabibliotecario.repositories.LivroRepository;
import com.projetofinal.sistemabibliotecario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void instanciaDB() {
        Usuario user1 = new Usuario(null, "Rafael", "rafael@email.com", "134");
        user1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Samuel", "samuel@email.com", "Quadra 22 Casa 20", "Itapoã");

        Livro liv1 = new Livro(null, "Harry Potter", "J. K. Rowling", "hboMax",
                "Livro do Harry", null, 1);

        Emprestimo emp1 = new Emprestimo(null, 2, cli1, liv1);

        usuarioRepository.saveAll(Arrays.asList(user1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        livroRepository.saveAll(Arrays.asList(liv1));
        emprestimoRepository.saveAll(Arrays.asList(emp1));
    }
}
