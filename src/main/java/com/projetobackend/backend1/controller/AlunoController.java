package com.projetobackend.backend1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetobackend.backend1.model.Aluno;
import com.projetobackend.backend1.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {
    
    private final AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> list() {
        return alunoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping("/matricula/{matriculaAluno}")
    public ResponseEntity<Aluno> findByMatricula(@PathVariable Long matriculaAluno) {
        return alunoRepository.findById(matriculaAluno).map(recordFound -> ResponseEntity.ok().body(recordFound)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listarAluno/{nome}")
    public List<Aluno> listarPorNome(@PathVariable String nome) {
        return alunoRepository.findByNome(nome);
    }

    @GetMapping("/listarClasse/{classe}")
    public List<Aluno> listarPorClasse(@PathVariable String classe) {
        return alunoRepository.findByTurmaOuClasse(classe);
    }
    
    @PutMapping("/update/{matriculaAluno}")
    public ResponseEntity<Aluno> update(@PathVariable Long matriculaAluno, @RequestBody Aluno aluno) {
        return alunoRepository.findById(matriculaAluno).map(recordFound -> {
            recordFound.setNome(aluno.getNome());
            recordFound.setEndereco(aluno.getEndereco());
            recordFound.setTelefone(aluno.getTelefone());
            recordFound.setEmail(aluno.getEmail());
            recordFound.setTurmaOuClasse(aluno.getTurmaOuClasse());
            Aluno updated = alunoRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{matriculaAluno}")
    public ResponseEntity<Void> delete(@PathVariable Long matriculaAluno, @RequestBody Aluno aluno) {
        return alunoRepository.findById(matriculaAluno).map(recordFound -> {
            alunoRepository.deleteById(matriculaAluno);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
