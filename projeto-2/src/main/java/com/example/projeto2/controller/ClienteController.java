package com.example.projeto2.controller;

import com.example.projeto2.model.Cliente;
import com.example.projeto2.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor // Substitui o construtor
public class ClienteController {
   private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @GetMapping
    public List<Cliente> Listar() {
        return clienteRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(cliente);
    }
}
