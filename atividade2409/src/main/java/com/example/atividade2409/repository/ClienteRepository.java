package com.example.atividade2409.repository;

import com.example.atividade2409.model.Cliente;
import com.example.atividade2409.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByprotocoloAtendimento(String protocoloAtendimento);
}
