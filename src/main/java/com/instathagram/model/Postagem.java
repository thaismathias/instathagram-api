package com.instathagram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Perfil perfil;

    @NotBlank
    private String urlFotoPostagem;

    private String legenda = "";
    private Integer n_curtidas = 0;
    private Integer n_comentarios = 0;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataPostagem;

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postagem postagem = (Postagem) o;
        return Objects.equals(id, postagem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
