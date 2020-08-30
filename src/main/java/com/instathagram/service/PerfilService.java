package com.instathagram.service;

import com.instathagram.exception.NegocioException;
import com.instathagram.model.Perfil;
import com.instathagram.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    //Criar conta
    public Perfil criar(Perfil perfil){

        if (perfilRepository.findByUsername(perfil.getUsername()).isPresent()) {
            throw new NegocioException("Nome de usuário já existe.");
        }

        if (perfilRepository.findByEmail(perfil.getEmail()).isPresent()) {
            throw new NegocioException("Email já existe.");
        }

        return perfilRepository.save(perfil);
    }

    //Inativar conta
    public void delete(Perfil perfil) {
        perfil.setContaAtiva(false);
        perfilRepository.save(perfil);
    }

    //Reativar conta
    public void reativar(Perfil perfil) {
        perfil.setContaAtiva(true);
        perfilRepository.save(perfil);
    }

}
