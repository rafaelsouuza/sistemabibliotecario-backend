package com.projetofinal.sistemabibliotecario.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.sistemabibliotecario.domain.Cliente;
import com.projetofinal.sistemabibliotecario.domain.Emprestimo;
import com.projetofinal.sistemabibliotecario.domain.Livro;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

public class EmprestimoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo NOME é requerido")
    private Integer qtd;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataEmprestimo = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataDevolucao  = dataEmprestimo.plusDays(30);

    private Cliente cliente;

    private Livro livro;

    public EmprestimoDTO() {
        super();
    }

    public EmprestimoDTO(Emprestimo obj) {
        this.id = obj.getId();
        this.qtd = obj.getQtd();
        this.cliente = obj.getCliente();
        this.livro = obj.getLivro();
        this.dataEmprestimo = obj.getDataEmprestimo();
        this.dataDevolucao = obj.getDataDevolucao();

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
}
