package com.projetobackend.backend1.model;

import jakarta.persistence.*;
import java.util.Date;

import lombok.Data;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long matriculaAluno;
    
    @Column(length = 200, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;

    @Column(length = 200, nullable = false)
    private String endereco;

    @Column(length = 200, nullable = false)
    private int telefone;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(length = 200, nullable = false)
    private String turmaOuClasse;

    @Temporal(TemporalType.DATE)
    private Date dataDeIngresso;

}
