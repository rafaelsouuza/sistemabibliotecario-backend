package com.projetofinal.sistemabibliotecario.resources;

import com.projetofinal.sistemabibliotecario.domain.Livro;
import com.projetofinal.sistemabibliotecario.domain.dtos.LivroDTO;
import com.projetofinal.sistemabibliotecario.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll() {
        List<Livro> list = livroService.findAll();
        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> create(@Valid @RequestBody LivroDTO objDTO) {
        Livro newObj = livroService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @Valid @RequestBody LivroDTO objDTO) {
        Livro obj = livroService.update(id, objDTO);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> delete (@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
