package com.instathagram.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    @Size(max = 60)
    private String username;

    @NotBlank
    @Size(min=8, max = 20)
    private String senha;

    @NotBlank
    @Email
    private String email;

    private Integer n_publicacao = 0;
    private Integer n_seguidores = 0;
    private Integer n_seguindo = 0;
    private String urlFoto = "https://api.adorable.io/avatars/285/default.png";
    private Boolean contaAtiva = true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(Boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return id.equals(perfil.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
