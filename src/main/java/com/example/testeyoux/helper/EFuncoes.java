package com.example.testeyoux.helper;

public enum EFuncoes {
    MEDICO("medico"),
    ENFERMEIRO("enfermeiro");

    private String descricao;

    EFuncoes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
