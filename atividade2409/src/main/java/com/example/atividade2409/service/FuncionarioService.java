package com.example.atividade2409.service;

import com.example.atividade2409.model.Funcionario;
import com.example.atividade2409.repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }
    public List<Funcionario> ListarTodos(){
        return funcionarioRepository.findAll();
    }
    if (funcionarioRepository.findByEmail)
}
