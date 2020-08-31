package com.instathagram.service;

import com.instathagram.exception.EntidadeNaoEncontradaException;
import com.instathagram.model.Comentario;
import com.instathagram.model.Perfil;
import com.instathagram.model.Postagem;
import com.instathagram.repository.ComentarioRepository;
import com.instathagram.repository.PerfilRepository;
import com.instathagram.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.OffsetDateTime;
import java.util.Optional;


@Service
public class GestaoPostagemService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    //Postar foto
    public Postagem criar(Postagem postagem) {
        Perfil perfil = perfilRepository.findByIdAndContaAtiva(postagem.getPerfil().getId(), true)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Perfil não encontrado ou inativo."));

        perfil.setN_publicacao(perfil.getN_publicacao() + 1);

        postagem.setPerfil(perfil);
        postagem.setDataPostagem(OffsetDateTime.now());

        return postagemRepository.save(postagem);
    }

    //Deletar foto
    public void excluir(Long postagemId) {
        Postagem postagem = postagemRepository.findById(postagemId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Postagem não encontrda."));

        Perfil perfil = postagem.getPerfil();

        if (perfil.getN_publicacao() > 0) {
            perfil.setN_publicacao(perfil.getN_publicacao() - 1);
            perfilRepository.save(perfil);
        }

        postagemRepository.delete(postagem);
    }

    //Add comentário em uma postagem
    public Comentario addComentario(Postagem postagem, Perfil comentarioPerfil, Comentario comentario) {

        postagem.setN_comentarios(postagem.getN_comentarios() + 1);

        comentario.setPerfil(comentarioPerfil);
        comentario.setDataEnvio(OffsetDateTime.now());
        comentario.setPostagem(postagem);

        return comentarioRepository.save(comentario);
    }

    //Deletar comentário
    public void excluirComentario(Long comentarioId) {

        Optional<Comentario> comentario = comentarioRepository.findById(comentarioId);

        if (comentario.isPresent()) {
            Postagem postagem = comentario.get().getPostagem();
            if (postagem.getN_comentarios() > 0) {
                postagem.setN_comentarios(postagem.getN_comentarios() - 1);

                postagemRepository.save(postagem);

                comentarioRepository.deleteById(comentarioId);
            }
        }
    }
}
