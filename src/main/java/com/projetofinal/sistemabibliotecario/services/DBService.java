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

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Usuario user1 = new Usuario(null, "Rafael", "268.321.820-66", "rafael@email.com", encoder.encode("123"));
        user1.addPerfil(Perfil.ADMIN);
        Usuario user2 = new Usuario(null, "Samuel", "492.802.380-35", "samuel@email.com", encoder.encode("123"));
        Usuario user3 = new Usuario(null, "Lucas", "106.512.860-69", "lucas@email.com", encoder.encode("123"));
        Usuario user4 = new Usuario(null, "Tiago", "155.760.620-00", "tiago@email.com", encoder.encode("123"));
        Usuario user5 = new Usuario(null, "Edvan", "374.280.500-22", "edvan@email.com", encoder.encode("123"));
        Usuario user6 = new Usuario(null, "James", "400.522.370-28", "james@email.com", encoder.encode("123"));
        Usuario user7 = new Usuario(null, "luana", "707.958.420-58", "luana@email.com", encoder.encode("123"));
        Usuario user8 = new Usuario(null, "kelly", "656.935.950-99", "kelly@email.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "Samuel", "samuel@email.com", "61984535533", "782.252.390-24", "Quadra 22 Casa 20", "Itapoã");
        Cliente cli2 = new Cliente(null, "Rafael", "rafael@email.com", "61984569533", "140.135.960-40", "Quadra 22 Casa 20", "Itapoã");
        Cliente cli3 = new Cliente(null, "Tiago", "tiago@email.com", "61988575593", "082.346.510-13", "Quadra 30 Casa 19", "Itapoã");
        Cliente cli4 = new Cliente(null, "Edvan", "edvanl@email.com", "61954669533", "058.774.770-64", "Quadra 40 Casa 03", "Itapoã");

        Livro liv1 = new Livro(null, "Harry Potter", "978 – 85 – 333 – 0227 – 3", "J. K. Rowling", "hboMax",
                "Livro do Harry", "2003");

        Livro liv2 = new Livro(null, "Harry Potter 2", "978 – 85 – 443 – 0227 – 3", "J. K. Rowling", "hboMax",
                "Livro do Harry é a camera secreta", "2007");

        Emprestimo emp1 = new Emprestimo(null,  cli1, liv1, Status.EMPRESTADO);
        Emprestimo emp2 = new Emprestimo(null, cli2, liv1, Status.ATRASADO);
        Emprestimo emp3 = new Emprestimo(null, cli3, liv2, Status.EMPRESTADO);
        Emprestimo emp4 = new Emprestimo(null, cli4, liv2, Status.DEVOLVIDO);
        Emprestimo emp5 = new Emprestimo(null, cli2, liv2, Status.ATRASADO);
        Emprestimo emp6 = new Emprestimo(null, cli3, liv1, Status.DEVOLVIDO);

        usuarioRepository.saveAll(Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8));
        clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
        livroRepository.saveAll(Arrays.asList(liv1,liv2));
        emprestimoRepository.saveAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6));
    }
}
