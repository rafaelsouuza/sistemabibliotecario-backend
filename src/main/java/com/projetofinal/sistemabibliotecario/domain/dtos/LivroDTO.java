package com.projetofinal.sistemabibliotecario.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.sistemabibliotecario.domain.Livro;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

public class LivroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo TÍTULO é requerido")
    private String titulo;

    @NotNull(message = "O campo ISBN é requerido")
    private String isbn;

    @NotNull(message = "O campo AUTOR é requerido")
    private String autor;

    @NotNull(message = "O campo EDITORA é requerido")
    private String editora;

    private String assunto;

    @NotNull(message = "O campo ANO LANÇAMENTO é requerido")
    private String anoLancamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.autor = obj.getAutor();
        this.editora = obj.getEditora();
        this.assunto = obj.getAssunto();
        this.anoLancamento = obj.getAnoLancamento();
        this.isbn = obj.getIsbn();
        this.dataCadastro = obj.getDataCadastro();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
