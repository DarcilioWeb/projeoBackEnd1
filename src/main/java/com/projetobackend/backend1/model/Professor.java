package com.projetobackend.backend1.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long matriculaProfessor;
    
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
    private String disciplinaLeciona;

    @Temporal(TemporalType.DATE)
    private Date dataDeContratacao;

}
