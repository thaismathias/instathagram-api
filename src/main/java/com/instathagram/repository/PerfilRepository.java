package com.instathagram.repository;

import com.instathagram.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

   Optional<Perfil> findByUsername(String username);
   Optional<Perfil> findByEmail(String email);
   List<Perfil> findByContaAtiva(Boolean status);
   Optional<Perfil> findByIdAndContaAtiva(Long perfilId, boolean ativa);
}
