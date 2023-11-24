package com.projetobackend.backend1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetobackend.backend1.model.Professor;
import com.projetobackend.backend1.repository.ProfessorRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {
    
    private final ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> list() {
        return professorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Professor create(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
    
    @GetMapping("/matricula/{matriculaProfessor}")
    public ResponseEntity<Professor> findByMatricula(@PathVariable Long matriculaProfessor) {
        return professorRepository.findById(matriculaProfessor).map(recordFound -> ResponseEntity.ok().body(recordFound)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listarProfessor/{nome}")
    public List<Professor> listarPorNome(@PathVariable String nome) {
        return professorRepository.findByNome(nome);
    }

    @GetMapping("/listarDisciplina/{disciplina}")
    public List<Professor> listarPorClasse(@PathVariable String disciplina) {
        return professorRepository.findByDisciplinaLeciona(disciplina);
    }
    
    @PutMapping("/update/{matriculaProfessor}")
    public ResponseEntity<Professor> update(@PathVariable Long matriculaProfessor, @RequestBody Professor professor) {
        return professorRepository.findById(matriculaProfessor).map(recordFound -> {
            recordFound.setNome(professor.getNome());
            recordFound.setEndereco(professor.getEndereco());
            recordFound.setTelefone(professor.getTelefone());
            recordFound.setEmail(professor.getEmail());
            recordFound.setDisciplinaLeciona(professor.getDisciplinaLeciona());
            Professor updated = professorRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{matriculaProfessor}")
    public ResponseEntity<Void> delete(@PathVariable Long matriculaProfessor, @RequestBody Professor professor) {
        return professorRepository.findById(matriculaProfessor).map(recordFound -> {
            professorRepository.deleteById(matriculaProfessor);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
    

