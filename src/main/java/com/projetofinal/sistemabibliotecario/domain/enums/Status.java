package com.projetofinal.sistemabibliotecario.domain.enums;

public enum Status {

    EMPRESTADO(0, "EMPRESTADO"), DEVOLVIDO(1, "DEVOLVIDO"), ATRASADO(2, "ATRASADO");

    private Integer codigo;
    private String descricao;

    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Status x : Status.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
