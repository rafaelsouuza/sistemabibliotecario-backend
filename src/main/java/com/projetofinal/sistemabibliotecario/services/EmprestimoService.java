package com.projetofinal.sistemabibliotecario.services;

import com.projetofinal.sistemabibliotecario.domain.Cliente;
import com.projetofinal.sistemabibliotecario.domain.Emprestimo;
import com.projetofinal.sistemabibliotecario.domain.Livro;
import com.projetofinal.sistemabibliotecario.domain.dtos.EmprestimoDTO;
import com.projetofinal.sistemabibliotecario.repositories.EmprestimoRepository;
import com.projetofinal.sistemabibliotecario.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroService livroService;
    @Autowired
    private ClienteService clienteService;

    public Emprestimo findById(Integer id) {
        Optional<Emprestimo> obj = emprestimoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo create(EmprestimoDTO objDTO) {
        return emprestimoRepository.save(newEmprestimo(objDTO));
    }

    public Emprestimo update(Integer id, @Valid EmprestimoDTO objDTO) {
        objDTO.setId(id);
        Emprestimo oldObj = findById(id);
        oldObj = newEmprestimo(objDTO);
        return emprestimoRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Emprestimo obj = findById(id);
        emprestimoRepository.deleteById(id);
    }

    private Emprestimo newEmprestimo(EmprestimoDTO obj) {
        Livro livro = livroService.findById(obj.getLivro());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Emprestimo emprestimo = new Emprestimo();
        if (obj.getId() != null) {
            emprestimo.setId(obj.getId());
        }

        emprestimo.setLivro(livro);
        emprestimo.setCliente(cliente);
        emprestimo.setQtd(obj.getQtd());
        return emprestimo;
    }
}
