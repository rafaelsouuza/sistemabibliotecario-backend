package com.projetofinal.sistemabibliotecario.services;

import com.projetofinal.sistemabibliotecario.domain.Cliente;
import com.projetofinal.sistemabibliotecario.domain.Emprestimo;
import com.projetofinal.sistemabibliotecario.domain.Livro;
import com.projetofinal.sistemabibliotecario.domain.Usuario;
import com.projetofinal.sistemabibliotecario.domain.enums.Perfil;
import com.projetofinal.sistemabibliotecario.domain.enums.Status;
import com.projetofinal.sistemabibliotecario.repositories.ClienteRepository;
import com.projetofinal.sistemabibliotecario.repositories.EmprestimoRepository;
import com.projetofinal.sistemabibliotecario.repositories.LivroRepository;
import com.projetofinal.sistemabibliotecario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB() {
        Usuario user1 = new Usuario(null, "Rafael", "rafael@email.com", encoder.encode("123"));
        user1.addPerfil(Perfil.ADMIN);
        Usuario user2 = new Usuario(null, "Samuel", "samuel@email.com", encoder.encode("123"));
        Usuario user3 = new Usuario(null, "Lucas", "lucas@email.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "Samuel", "samuel@email.com", "Quadra 22 Casa 20", "Itapoã");
        Cliente cli2 = new Cliente(null, "Rafael", "rafael@email.com", "Quadra 22 Casa 20", "Itapoã");

        Livro liv1 = new Livro(null, "Harry Potter", "J. K. Rowling", "hboMax",
                "Livro do Harry", null, 1);

        Livro liv2 = new Livro(null, "Harry Potter 2", "J. K. Rowling", "hboMax",
                "Livro do Harry é a camera secreta", null, 2);

        Emprestimo emp1 = new Emprestimo(null, 2, cli1, liv1, Status.EMPRESTADO);
        Emprestimo emp2 = new Emprestimo(null, 2, cli2, liv1, Status.DEVOLVIDO);

        usuarioRepository.saveAll(Arrays.asList(user1,user2,user3));
        clienteRepository.saveAll(Arrays.asList(cli1,cli2));
        livroRepository.saveAll(Arrays.asList(liv1,liv2));
        emprestimoRepository.saveAll(Arrays.asList(emp1,emp2));
    }
}
