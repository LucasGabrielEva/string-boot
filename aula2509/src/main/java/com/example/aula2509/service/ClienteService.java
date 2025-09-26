package com.example.aula2509.service;

import com.example.aula2509.model.Cliente;
import com.example.aula2509.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    //Get - Read
    public List<Cliente> ListarTodos(){
        return clienteRepository.findAll();
    }
    //Post - Create
    public Cliente salvar(Cliente cliente) {
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente não casdastrado");
        }
        return clienteRepository.save(cliente);
    }
    //Put - Update
    public Cliente atualizar(UUID id,Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        cliente.setId(id);
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return clienteAtualizado;
    }
    //delete
    public void excluir(UUID id){
        if (clienteRepository.existsById(id)) {
            throw new RuntimeException("cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

}
