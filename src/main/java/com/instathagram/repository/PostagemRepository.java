package com.instathagram.repository;

import com.instathagram.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    Optional<Postagem> findById(Long postagemId);
}
