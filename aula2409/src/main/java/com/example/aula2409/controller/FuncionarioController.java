package com.example.aula2409.controller;

import com.example.aula2409.model.Funcionario;
import com.example.aula2409.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    @GetMapping
    public List<Funcionario> ListarFuncionario() {
        return funcionarioService.ListarTodos();
    }
    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncioanarios(@RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }
}
