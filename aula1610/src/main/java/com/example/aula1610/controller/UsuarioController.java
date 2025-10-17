package com.example.aula1610.controller;

import com.example.aula1610.dto.UsuarioRequestDTO;
import com.example.aula1610.dto.UsuarioResponseDTO;
import com.example.aula1610.service.UsuarioService;
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
    //Create
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity
                .created(null)
                .body(Map.of(
                        "mensagem", "cadastrado com sucesso",
                        "sucesso", true
                ));
    }
    //Read
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> Listar(){
        return ResponseEntity
                .ok()
                .body(usuarioService.ListaTodos());

    }
    //UPDATE
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO dto) {
        usuarioService.atualizarUsuario(id, dto);

        return ResponseEntity
                .ok()
                .body(Map.of(
                        "mensagem", "Atualizado com sucesso.",
                        "sucesso", true
                ));
    }
    //Delete
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity
                .ok()
                .body(Map.of(
                        "mensagem","Excluido com sucesso.",
                        "sucesso", true
                ));
    }

}
