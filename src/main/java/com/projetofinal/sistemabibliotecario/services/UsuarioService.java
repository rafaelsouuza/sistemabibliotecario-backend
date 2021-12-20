package com.projetofinal.sistemabibliotecario.services;

import com.projetofinal.sistemabibliotecario.domain.Usuario;
import com.projetofinal.sistemabibliotecario.domain.dtos.UsuarioDTO;
import com.projetofinal.sistemabibliotecario.repositories.UsuarioRepository;
import com.projetofinal.sistemabibliotecario.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(UsuarioDTO objDTO) {
        objDTO.setId(null);
        Usuario newObj = new Usuario(objDTO);
        return usuarioRepository.save(newObj);
    }

    public Usuario update(Integer id, @Valid UsuarioDTO objDTO) {
        objDTO.setId(id);
        Usuario oldObj = findById(id);
        oldObj = new Usuario (objDTO);
        return usuarioRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Usuario obj = findById(id);
        usuarioRepository.deleteById(id);
    }
}
