package com.example.aula0810.service;

import com.example.aula0810.model.FuncionarioModel;
import com.example.aula0810.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncioanarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> ListaTodos(){
        return funcionarioRepository.findAll();
    }
    public FuncionarioModel salvar(FuncionarioModel funcionarioModel){
        if (funcionarioRepository.findByEmail(funcionarioModel.getEmail()).isPresent()){
            throw new IllegalArgumentException("Funcionario não cadastrado");
        }
        return funcionarioRepository.save(funcionarioModel);

    }
    public FuncionarioModel atualizar(Long id, FuncionarioModel funcionario){
        if (!funcionarioRepository.existsById(id)){
            throw new IllegalArgumentException("Funcionario não encontrado");
        }
        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }
    public void excluir(Long id){
        if (!funcionarioRepository.existsById(id)){
            throw  new RuntimeException("Funcionario não encontrado");
        }
        funcionarioRepository.deleteById(id);
    }
}
