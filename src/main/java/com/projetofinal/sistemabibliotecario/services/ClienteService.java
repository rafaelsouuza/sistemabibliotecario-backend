package com.projetofinal.sistemabibliotecario.services;

import com.projetofinal.sistemabibliotecario.domain.Cliente;
import com.projetofinal.sistemabibliotecario.domain.dtos.ClienteDTO;
import com.projetofinal.sistemabibliotecario.repositories.ClienteRepository;
import com.projetofinal.sistemabibliotecario.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        Cliente newObj = new Cliente(objDTO);
        return clienteRepository.save(newObj);
    }
}
