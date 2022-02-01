package com.projetofinal.sistemabibliotecario.domain;

import com.projetofinal.sistemabibliotecario.domain.dtos.LivroDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String isbn;
    private String autor;
    private String editora;
    private String assunto;
    private String anoLancamento;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String isbn, String autor, String editora, String assunto, String anoLancamento
                 ) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editora = editora;
        this.assunto = assunto;
        this.anoLancamento = anoLancamento;
    }

    public Livro(LivroDTO obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.autor = obj.getAutor();
        this.isbn = obj.getIsbn();
        this.editora = obj.getEditora();
        this.assunto = obj.getAssunto();
        this.anoLancamento = obj.getAnoLancamento();
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
