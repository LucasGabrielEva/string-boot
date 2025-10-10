package com.example.aula0910.controller;

import com.example.aula0910.model.FuncionarioModel;
import com.example.aula0910.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioModel> ListaTodos(){
        return funcionarioService.listaTodos();
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioModel funcionarioModel){
        funcionarioService.salvar(funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","Cadastrado com sucesso"));

    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(Long id,@RequestBody FuncionarioModel funcionarioModel){
        funcionarioService.atualizar(id, funcionarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Cadastrado com sucesso"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> deletefuncionario(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","funcionario"));
    }


}
