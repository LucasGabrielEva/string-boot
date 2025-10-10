package com.example.aula0910.controller;

import com.example.aula0910.model.ClienteModel;
import com.example.aula0910.service.ClienteService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteModel> ListaTodos(){
        return clienteService.ListaTodos();
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClienteModel clienteModel) {
        clienteService.salvar(clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","Cadastrado com sucesso"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(Long id, @RequestBody ClienteModel clienteModel){
        clienteService.atualizar(id, clienteModel);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Cadastrado com sucesso"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> deletecliente(@PathVariable Long id){
        clienteService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","cliente"));
    }
}
