package com.projetobackend.backend1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetobackend.backend1.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
    List<Professor> findByNome(String nome);
    
    List<Professor> findByDisciplinaLeciona(String disciplinaLeciona);
}
