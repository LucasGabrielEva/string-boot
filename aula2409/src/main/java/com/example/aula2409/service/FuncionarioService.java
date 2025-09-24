package com.example.aula2409.service;

import com.example.aula2409.model.Funcionario;
import com.example.aula2409.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }
    //GET
    public List<Funcionario> ListarTodos(){
        return funcionarioRepository.findAll();
    }
    //POST
    public Funcionario salvar(Funcionario funcionario) {
        //verifica se o funcionario ja esta cadastrado.
        if (funcionarioRepository.findByTelefone(funcionario.getTelefone()).isPresent()) {
            //se encontrado a telefone de funcionario no banco de dados, mostra mensagem.
            throw new RuntimeException("Funcionario já cadastrado. ");//exception e uma exerção
        }
       //caso não encontre o telefone no Banco de Dados, salva o funcionario.
        return  funcionarioRepository.save(funcionario);
    }
}
