package com.example.aula1510.controller;

import com.example.aula1510.dto.UsuarioRequestDTO;
import com.example.aula1510.dto.UsuarioResponseDTO;
import com.example.aula1510.model.UsuarioModel;
import com.example.aula1510.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto){
         usuarioService.salvarUsuario(dto);

        return ResponseEntity
                .created(null)
                .body(Map.of("mensagem", "Usuário cadastrado com sucesso", "sucesso",
                        true));
    }
    @GetMapping
   //Retorna uma Lista com apenas o nome em e-mail.
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity
                .ok()
                .body(usuarioService.ListaTodos());

    }


}
