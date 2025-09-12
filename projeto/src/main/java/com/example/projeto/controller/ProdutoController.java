package com.example.projeto.controller;

import com.example.projeto.model.Cliente;
import com.example.projeto.model.Produto;
import com.example.projeto.repository.ProdutoRepository;
import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @GetMapping
    public List(Produto) ListaTodos() {
        return produtoRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
}
