package com.instathagram.api.controller;

import com.instathagram.model.Comentario;
import com.instathagram.model.Postagem;
import com.instathagram.exception.EntidadeNaoEncontradaException;
import com.instathagram.api.model.ComentarioInput;
import com.instathagram.api.model.ComentarioOutput;
import com.instathagram.repository.ComentarioRepository;
import com.instathagram.repository.PostagemRepository;
import com.instathagram.service.GestaoPostagemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/postagens/{postagemId}/comentarios")
public class ComentarioController {

    @Autowired
    private GestaoPostagemService gestaoPostagemService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    //Adicionar comentário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioOutput add(@PathVariable Long postagemId,
                                @Valid @RequestBody ComentarioInput comentarioInput) {
        Comentario comentario = gestaoPostagemService.addComentario(postagemId,
                comentarioInput.getDescricao());

        return toModel (comentario);
    }

    //Listar comantários
    @GetMapping
    public List<ComentarioOutput> listar(@PathVariable Long postagemId) {
        Postagem postagem = postagemRepository.findById(postagemId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Foto não encontrada."));

        return toCollectionModel(postagem.getComentarios());
    }

    //Deletar comentário
    @DeleteMapping("/{comentarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> remover(@PathVariable Long comentarioId) {
        if (!comentarioRepository.existsById(comentarioId)){
            return ResponseEntity.notFound().build(); //ToDo Comentário não encontrado
        }
        gestaoPostagemService.excluirComentario(comentarioId);

        return ResponseEntity.noContent().build(); //Retorna 204
    }

    private ComentarioOutput toModel(Comentario comentario){
        return modelMapper.map(comentario, ComentarioOutput.class);
    }

    private List<ComentarioOutput> toCollectionModel (List<Comentario> comentarios) {
        return comentarios.stream()
                .map(coment -> toModel(coment))
                .collect(Collectors.toList());
    }
}
