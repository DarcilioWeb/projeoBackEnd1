package com.projetobackend.backend1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetobackend.backend1.model.Funcionario;
import com.projetobackend.backend1.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioController {
    
    private final FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> list() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Funcionario create(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/matricula/{matriculaFuncionario}")
    public ResponseEntity<Funcionario> findByMatricula(@PathVariable Long matriculaFuncionario) {
        return funcionarioRepository.findById(matriculaFuncionario).map(recordFound -> ResponseEntity.ok().body(recordFound)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listarFuncionario/{nome}")
    public List<Funcionario> listarPorNome(@PathVariable String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    @GetMapping("/listarCargo/{cargo}")
    public List<Funcionario> listarPorCargo(@PathVariable String cargo) {
        return funcionarioRepository.findByCargo(cargo);
    }

    @PutMapping("/update/{matriculaFuncionario}")
    public ResponseEntity<Funcionario> update(@PathVariable Long matriculaFuncionario, @RequestBody Funcionario funcionario) {
        return funcionarioRepository.findById(matriculaFuncionario).map(recordFound -> {
            recordFound.setNome(funcionario.getNome());
            recordFound.setEndereco(funcionario.getEndereco());
            recordFound.setTelefone(funcionario.getTelefone());
            recordFound.setEmail(funcionario.getEmail());
            recordFound.setCargo(funcionario.getCargo());
            Funcionario updated = funcionarioRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{matriculaFuncionario}")
    public ResponseEntity<Void> delete(@PathVariable Long matriculaFuncionario, @RequestBody Funcionario funcionario) {
        return funcionarioRepository.findById(matriculaFuncionario).map(recordFound -> {
            funcionarioRepository.deleteById(matriculaFuncionario);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
