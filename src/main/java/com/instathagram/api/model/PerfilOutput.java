package com.instathagram.api.model;

public class PerfilOutput {

    private String name;
    private String username;
    private Integer n_publicacao;
    private Integer n_seguidores;
    private Integer n_seguindo;
    private String urlFoto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getN_publicacao() {
        return n_publicacao;
    }

    public void setN_publicacao(Integer n_publicacao) {
        this.n_publicacao = n_publicacao;
    }

    public Integer getN_seguidores() {
        return n_seguidores;
    }

    public void setN_seguidores(Integer n_seguidores) {
        this.n_seguidores = n_seguidores;
    }

    public Integer getN_seguindo() {
        return n_seguindo;
    }

    public void setN_seguindo(Integer n_seguindo) {
        this.n_seguindo = n_seguindo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
