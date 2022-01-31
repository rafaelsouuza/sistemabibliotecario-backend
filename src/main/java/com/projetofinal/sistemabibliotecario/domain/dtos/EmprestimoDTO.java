package com.projetofinal.sistemabibliotecario.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.sistemabibliotecario.domain.Emprestimo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class EmprestimoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimo = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucao;
    @NotNull(message = "O campo PRIORIDADE é requerido")
    private Integer status;
    @NotNull(message = "O campo CLIENTE é requerido")
    private Integer cliente;
    @NotNull(message = "O campo LIVRO é requerido")
    private Integer livro;
    private String nomeCliente;
    private String nomeLivro;

    public EmprestimoDTO() {
        super();
    }

    public EmprestimoDTO(Emprestimo obj) {
        this.id = obj.getId();
        this.cliente = obj.getCliente().getId();
        this.livro = obj.getLivro().getId();
        this.dataEmprestimo = obj.getDataEmprestimo();
        this.dataDevolucao = obj.getDataDevolucao();
        this.status = obj.getStatus().getCodigo();
        this.nomeCliente = obj.getCliente().getNome();
        this.nomeLivro = obj.getLivro().getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getLivro() {
        return livro;
    }

    public void setLivro(Integer livro) {
        this.livro = livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
