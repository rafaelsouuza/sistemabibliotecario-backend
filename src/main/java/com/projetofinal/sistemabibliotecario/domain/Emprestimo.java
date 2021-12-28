package com.projetofinal.sistemabibliotecario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.sistemabibliotecario.domain.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer qtd;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataEmprestimo = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataDevolucao;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Emprestimo() {
        super();
    }

    public Emprestimo(Integer id, Integer qtd, Cliente cliente, Livro livro, Status status) {
        this.id = id;
        this.qtd = qtd;
        this.cliente = cliente;
        this.livro = livro;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
