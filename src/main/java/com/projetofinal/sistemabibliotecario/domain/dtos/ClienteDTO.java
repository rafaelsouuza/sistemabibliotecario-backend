package com.projetofinal.sistemabibliotecario.domain.dtos;

import com.projetofinal.sistemabibliotecario.domain.Cliente;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo NOME é requerido")
    private String nome;

    @NotNull(message = "O campo E-MAIL é requerido")
    private String email;

    @NotNull(message = "O campo ENDEREÇO é requerido")
    private String endereco;

    @NotNull(message = "O campo CIDADE é requerido")
    private String cidade;

    public ClienteDTO() {
        super();
    }

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.endereco = obj.getEndereco();
        this.cidade = obj.getCidade();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
