package com.example.aula0810.controller;

import com.example.aula0810.model.FuncionarioModel;
import com.example.aula0810.service.FuncioanarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncioanarioService funcioanarioService;

    @GetMapping
    public List<FuncionarioModel> listar(){
        return funcioanarioService.ListaTodos();

    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioModel funcionarioModel) {
        funcioanarioService.salvar(funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cadastrado com sucesso"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<Spring, Object>> atualizar(Long id, @RequestBody FuncionarioModel funcionarioModel){
        funcioanarioService.atualizar(id, funcionarioModel);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Cadastrado com sucesso"));


    }
    @DeleteMapping



}
