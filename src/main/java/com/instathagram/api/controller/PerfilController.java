package com.instathagram.api.controller;

import com.instathagram.model.Perfil;
import com.instathagram.service.PerfilService;
import com.instathagram.api.model.PerfilInput;
import com.instathagram.api.model.PerfilOutput;
import com.instathagram.repository.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private ModelMapper modelMapper;

    //Listar todos os perfis
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PerfilOutput>> listar(){
        return ResponseEntity.ok(toCollectionModel(perfilRepository.findByContaAtiva(true)));
    }

    //Apresentar dados do perfil
    @GetMapping("/{perfilId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PerfilOutput> getPerfil(@PathVariable Long perfilId) {
        Optional<Perfil> perfil = perfilRepository.findByIdAndContaAtiva(perfilId, true);

        if (perfil.isPresent()) {
            PerfilOutput perfilOutput = toModel(perfil.get());
            return ResponseEntity.ok(perfilOutput);
        }
        return ResponseEntity.notFound().build();
    }

    //Abrir conta
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> criarConta(@Valid @RequestBody PerfilInput perfilInput) {
        perfilService.criar(toEntity(perfilInput));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Inativar conta
    @DeleteMapping("/{perfilId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePerfil(@PathVariable Long perfilId) {
        Optional<Perfil> perfil = perfilRepository.findById(perfilId);

        if (perfil.isPresent()) {
            perfilService.delete(perfil.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Reativar conta
    @PutMapping("/{perfilId}/reativar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> reativarPerfil(@PathVariable Long perfilId) {
        Optional<Perfil> perfil = perfilRepository.findByIdAndContaAtiva(perfilId, false);

        if (perfil.isPresent()) {
            perfilService.reativar(perfil.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Perfil toEntity(PerfilInput perfilInput) {
        return modelMapper.map(perfilInput, Perfil.class);
    }

    private PerfilOutput toModel (Perfil perfil){
            return modelMapper.map(perfil, PerfilOutput.class);
        }

    private List<PerfilOutput> toCollectionModel(List<Perfil> perfil) {
        return perfil.stream()
                .map(per -> toModel(per))
                .collect(Collectors.toList());
    }

}

