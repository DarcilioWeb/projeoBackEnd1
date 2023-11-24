package com.projetobackend.backend1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetobackend.backend1.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    List<Funcionario> findByCargo(String cargo);

    List<Funcionario> findByNome(String nome);
}
