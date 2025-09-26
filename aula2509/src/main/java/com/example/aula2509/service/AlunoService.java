package com.example.aula2509.service;

import com.example.aula2509.model.Aluno;
import com.example.aula2509.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    public List<Aluno> ListaTodos(){
        return alunoRepository.findAll();
    }
    public Aluno salvar(Aluno aluno) {
        if (alunoRepository.findByEmail(aluno.getEmail()).isPresent()){
            throw new RuntimeException("aluno não cadastrado");

        }
        return alunoRepository.save(aluno);
    }
    public Aluno atualizar(UUID id,Aluno aluno) {
        if (!alunoRepository.existsById(id)){
            throw new RuntimeException("aluno não encontrado");
        }
        aluno.setId(id);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return alunoAtualizado;
    }
    public void excluir(UUID id){

    }



}
