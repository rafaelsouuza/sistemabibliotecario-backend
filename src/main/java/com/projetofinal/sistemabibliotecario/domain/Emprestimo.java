package com.projetofinal.sistemabibliotecario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer qtd;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataEmprestimo = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataDevolucao  = dataEmprestimo.plusDays(30);

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Livro livro;

    public Emprestimo() {
        super();
    }

    public Emprestimo(Long id, Integer qtd, Cliente cliente, Livro livro) {
        this.id = id;
        this.qtd = qtd;
        this.cliente = cliente;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
