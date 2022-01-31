package com.projetofinal.sistemabibliotecario.services;

import com.projetofinal.sistemabibliotecario.domain.Cliente;
import com.projetofinal.sistemabibliotecario.domain.Usuario;
import com.projetofinal.sistemabibliotecario.domain.dtos.ClienteDTO;
import com.projetofinal.sistemabibliotecario.domain.dtos.UsuarioDTO;
import com.projetofinal.sistemabibliotecario.repositories.UsuarioRepository;
import com.projetofinal.sistemabibliotecario.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(UsuarioDTO objDTO) {
        objDTO.setId(null);
        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        validaPorCpfEEmail(objDTO);
        Usuario newObj = new Usuario(objDTO);
        return usuarioRepository.save(newObj);
    }

    public Usuario update(Integer id, @Valid UsuarioDTO objDTO) {
        objDTO.setId(id);
        Usuario oldObj = findById(id);

        if(!objDTO.getSenha().equals(oldObj.getSenha())) {
            objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        }

        validaPorCpfEEmail(objDTO);
        oldObj = new Usuario (objDTO);
        return usuarioRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Usuario obj = findById(id);
        usuarioRepository.deleteById(id);
    }

    private void validaPorCpfEEmail(UsuarioDTO objDTO) {
        Optional<Usuario> obj = usuarioRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = usuarioRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
