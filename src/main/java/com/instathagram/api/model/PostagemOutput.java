package com.instathagram.api.model;

import java.time.OffsetDateTime;

public class PostagemOutput {

    private Long id;
    private PerfilOutput perfil;
    private String urlFotoPostagem;
    private String legenda;
    private Integer n_curtidas;
    private Integer n_comentarios;
    private OffsetDateTime dataPostagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerfilOutput getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilOutput perfil) {
        this.perfil = perfil;
    }

    public String getUrlFotoPostagem() {
        return urlFotoPostagem;
    }

    public void setUrlFotoPostagem(String urlFotoPostagem) {
        this.urlFotoPostagem = urlFotoPostagem;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public Integer getN_curtidas() {
        return n_curtidas;
    }

    public void setN_curtidas(Integer n_curtidas) {
        this.n_curtidas = n_curtidas;
    }

    public Integer getN_comentarios() {
        return n_comentarios;
    }

    public void setN_comentarios(Integer n_comentarios) {
        this.n_comentarios = n_comentarios;
    }

    public OffsetDateTime getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(OffsetDateTime dataPostagem) {
        this.dataPostagem = dataPostagem;
    }
}
