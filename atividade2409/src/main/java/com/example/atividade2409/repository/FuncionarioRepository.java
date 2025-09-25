package com.example.atividade2409.repository;

import com.example.atividade2409.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    Optional<Funcionario> findByTelefone(String telefone);
    Optional<Funcionario> findByEmail(String email);

}
