package com.projetobackend.backend1.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long matriculaFuncionario;
    
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
    private String cargo;

    @Temporal(TemporalType.DATE)
    private Date dataDeContratacao;
}
