package com.instathagram.api.model;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PostagemInput {


    @NotNull
    private PerfilIdInput perfil;

    @NotBlank
    private String urlFotoPostagem;
    private String legenda;


    public PerfilIdInput getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilIdInput perfil) {
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

}
