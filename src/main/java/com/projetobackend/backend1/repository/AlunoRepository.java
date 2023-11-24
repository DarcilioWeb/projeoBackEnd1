package com.projetobackend.backend1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetobackend.backend1.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
    List<Aluno> findByNome(String nome);

    List<Aluno> findByTurmaOuClasse(String turmaOuClasse);
}
