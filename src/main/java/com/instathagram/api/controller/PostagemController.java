package com.instathagram.api.controller;


import com.instathagram.api.model.PostagemInput;
import com.instathagram.exception.EntidadeNaoEncontradaException;
import com.instathagram.model.Postagem;
import com.instathagram.service.GestaoPostagemService;
import com.instathagram.api.model.PostagemOutput;
import com.instathagram.repository.PostagemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private GestaoPostagemService gestaoPostagemService;

    @Autowired
    private ModelMapper modelMapper;

    //Listar todas postagens
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PostagemOutput>> listar(){
        return ResponseEntity.ok(toCollectionModel(postagemRepository.findAll()));
    }

    //Abrir post específico
    @GetMapping("/{postagemId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PostagemOutput> post(@PathVariable Long postagemId) {
        Postagem postagem = postagemRepository.findById(postagemId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Postagem não encontrada."));

        PostagemOutput postagemOutput = toModel(postagem);

        return ResponseEntity.ok(postagemOutput);
    }

    //Novo post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostagemOutput> novo(@Valid @RequestBody PostagemInput postagemInput) {
        Postagem postagem = toEntity(postagemInput);

        return new ResponseEntity<>(toModel(gestaoPostagemService.criar(postagem)), HttpStatus.CREATED);
    }

    //Excluir post
    @DeleteMapping("/{postagemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> remover(@PathVariable Long postagemId) {
        Postagem postagem = postagemRepository.findById(postagemId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Postagem não encontrada."));

        gestaoPostagemService.excluir(postagemId);

        return ResponseEntity.noContent().build();
    }

    private PostagemOutput toModel (Postagem postagem){
        return modelMapper.map(postagem, PostagemOutput.class);
    }

    private List<PostagemOutput> toCollectionModel(List<Postagem> postagem) {
        return postagem.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private Postagem toEntity(PostagemInput postagemInput) {
        return modelMapper.map(postagemInput, Postagem.class);
    }

}
