package com.projetofinal.sistemabibliotecario.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.sistemabibliotecario.domain.Usuario;
import com.projetofinal.sistemabibliotecario.domain.enums.Perfil;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo NOME é requerido")
    private String nome;

    @NotNull(message = "O campo E-MAIL é requerido")
    private String email;

    @NotNull(message = "O campo SENHA é requerido")
    private String senha;

    private Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datacriacao = LocalDate.now();

    public UsuarioDTO() {
        super();
        addPerfil(Perfil.USUARIO);
    }

    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.datacriacao = obj.getDataCriacao();
        addPerfil(Perfil.USUARIO);
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDate datacriacao) {
        this.datacriacao = datacriacao;
    }
}
