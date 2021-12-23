package com.projetofinal.sistemabibliotecario.resources;

import com.projetofinal.sistemabibliotecario.domain.Emprestimo;
import com.projetofinal.sistemabibliotecario.domain.dtos.EmprestimoDTO;
import com.projetofinal.sistemabibliotecario.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoResource {

    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmprestimoDTO> findById(@PathVariable Integer id) {
        Emprestimo obj = emprestimoService.findById(id);
        return ResponseEntity.ok().body(new EmprestimoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> findAll() {
        List<Emprestimo> list = emprestimoService.findAll();
        List<EmprestimoDTO> listDTO = list.stream().map(obj -> new EmprestimoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTO> create(@Valid @RequestBody EmprestimoDTO objDTO) {
        Emprestimo newObj = emprestimoService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmprestimoDTO> update(@PathVariable Integer id, @Valid @RequestBody EmprestimoDTO objDTO) {
        Emprestimo obj = emprestimoService.update(id, objDTO);
        return ResponseEntity.ok().body(new EmprestimoDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> delete (@PathVariable Integer id) {
        emprestimoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
