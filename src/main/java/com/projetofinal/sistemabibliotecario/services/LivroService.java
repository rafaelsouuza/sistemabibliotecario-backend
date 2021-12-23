package com.projetofinal.sistemabibliotecario.services;

import com.projetofinal.sistemabibliotecario.domain.Livro;
import com.projetofinal.sistemabibliotecario.domain.dtos.LivroDTO;
import com.projetofinal.sistemabibliotecario.repositories.LivroRepository;
import com.projetofinal.sistemabibliotecario.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro create(LivroDTO objDTO) {
        objDTO.setId(null);
        Livro newObj = new Livro(objDTO);
        return livroRepository.save(newObj);
    }

    public Livro update(Integer id, @Valid LivroDTO objDTO) {
        objDTO.setId(id);
        Livro oldObj = findById(id);
        oldObj = new Livro(objDTO);
        return livroRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Livro obj = findById(id);
        livroRepository.deleteById(id);
    }
}
