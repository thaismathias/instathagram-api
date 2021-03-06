package com.instathagram.api.model;

import java.time.OffsetDateTime;

public class ComentarioOutput {

    private Long id;
    private String descricao;
    private OffsetDateTime dataEnvio;
    private PerfilOutput perfil;

    public PerfilOutput getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilOutput perfil) {
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OffsetDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(OffsetDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
