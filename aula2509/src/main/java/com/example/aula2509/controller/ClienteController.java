package com.example.aula2509.controller;

import com.example.aula2509.model.Cliente;
import com.example.aula2509.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public List<Cliente> ListarCliente(){
        return clienteService.ListarTodos();

    }
    @PostMapping
    public ResponseEntity<Cliente> salvarclientes(@RequestBody Cliente cliente) {
        clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable UUID id,@RequestBody Cliente cLiente) {
        clienteService.atualizar(id,cLiente);
        return ResponseEntity.status(HttpStatus.OK).body(cLiente);

    }
    @DeleteMapping
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        clienteService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
