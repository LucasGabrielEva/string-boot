package com.example.atividade2409.repository;

import com.example.atividade2409.model.Funcionario;
import com.example.atividade2409.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Funcionario> findByTelefone(String telefone);
    Optional<Funcionario> findByEmail(String email);
}
