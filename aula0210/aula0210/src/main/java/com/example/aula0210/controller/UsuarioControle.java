package com.example.aula0210.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula0210.model.Usuario;
import com.example.aula0210.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControle {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> Listar() {
        return service.ListaTodos();
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody Usuario usuario) {
        service.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cadatrado com sucesso"));
    }


}
