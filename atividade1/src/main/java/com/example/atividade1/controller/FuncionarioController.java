package com.example.atividade1.controller;

import com.example.atividade1.model.FuncionarioModel;
import com.example.atividade1.service.FuncionarioService;
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
    private  FuncionarioService funcionarioService;

   @GetMapping
    public List<FuncionarioModel> ListaTodos(){
      return funcionarioService.ListaTodos();
   }

   @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioModel funcionarioModel){
       funcionarioService.salvar(funcionarioModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cadastrado com sucesso"));
   }
   @PutMapping
    public ResponseEntity<Map<String, Object>> atualiazar(Long id,@RequestBody FuncionarioModel funcionarioModel){
       funcionarioService.atualizar(id, funcionarioModel);
       return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Cadastrado com sucesso"));

   }
   @DeleteMapping
  public ResponseEntity<Map<String, Object>> deletefuncionario(@PathVariable Long id){
       funcionarioService.excluir(id);
       return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","funcionario"));
   }



}
