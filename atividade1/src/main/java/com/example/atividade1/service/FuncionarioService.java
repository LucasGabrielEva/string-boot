package com.example.atividade1.service;

import com.example.atividade1.model.FuncionarioModel;
import com.example.atividade1.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
   private FuncionarioRepository funcionarioRepository;

   public List<FuncionarioModel>ListaTodos(){
       return funcionarioRepository.findAll();
   }
   public FuncionarioModel salvar(FuncionarioModel funcionarioModel){
       if (funcionarioRepository.findByEmail(funcionarioModel.getEmail()).isPresent()){
           throw  new IllegalArgumentException("Funcionario não cadastrado");
       }
       return funcionarioRepository.save(funcionarioModel);
   }
   public FuncionarioModel atualizar(Long id, FuncionarioModel funcionario){
       if (!funcionarioRepository.existsById(id)){
           throw  new IllegalArgumentException("Funcionario não cadastrado");
       }
       funcionario.setId(id);
       return funcionarioRepository.save(funcionario);
   }
   public void excluir(Long id){
       if (!funcionarioRepository.existsById(id)){
           throw new RuntimeException("Funcionario não cadastrado");
       }
       funcionarioRepository.deleteById(id);
   }
}
