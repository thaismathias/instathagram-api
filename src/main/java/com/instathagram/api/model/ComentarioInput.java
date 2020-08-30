package com.instathagram.api.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class ComentarioInput {

    @NotNull
    private PerfilIdInput perfilId;

    @NotBlank
    private String descricao;

    public PerfilIdInput getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(PerfilIdInput perfilId) {
        this.perfilId = perfilId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
