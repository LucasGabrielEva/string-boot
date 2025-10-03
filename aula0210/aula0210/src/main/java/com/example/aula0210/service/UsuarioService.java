package com.example.aula0210.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula0210.exception.EmailCadastradoException;
import com.example.aula0210.model.Usuario;
import com.example.aula0210.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> ListaTodos(){
        return repository.findAll();

    }
    public Usuario salvar(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new EmailCadastradoException("Usuario já cadastrado");
            
        }
        return repository.save(usuario);
    }
    public Usuario atualizar(Long id, Usuario usuario) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
            
        }
        usuario.setId(id);
        return repository.save(usuario);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
            
        }
        repository.deleteById(id);
    }


}
