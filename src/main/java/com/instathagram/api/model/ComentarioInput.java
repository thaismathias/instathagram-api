package com.instathagram.api.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class ComentarioInput {

    @NotNull
    private PerfilIdInput perfil;

    @NotBlank
    private String descricao;

    public PerfilIdInput getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilIdInput perfil) {
        this.perfil = perfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
