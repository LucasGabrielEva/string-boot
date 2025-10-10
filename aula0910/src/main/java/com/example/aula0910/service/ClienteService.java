package com.example.aula0910.service;

import com.example.aula0910.model.ClienteModel;
import com.example.aula0910.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> ListaTodos(){
        return clienteRepository.findAll();
    }
    public ClienteModel salvar(ClienteModel clienteModel) {
        if (clienteRepository.findByEmail(clienteModel.getEmail()).isPresent()){
            throw new IllegalArgumentException("Cliente não cadastrado");
        }
        return clienteRepository.save(clienteModel);
    }
    public ClienteModel atualizar(Long id, ClienteModel cliente){
        if (!clienteRepository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }
    public void excluir(Long id){
        if (!clienteRepository.existsById(id)){
            throw new IllegalArgumentException("Clinte não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
