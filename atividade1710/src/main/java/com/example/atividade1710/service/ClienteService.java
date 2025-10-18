package com.example.atividade1710.service;

import com.example.atividade1710.dto.ClienteRequestDTO;
import com.example.atividade1710.dto.ClienteResponseDTO;
import com.example.atividade1710.model.ClienteModel;
import com.example.atividade1710.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ClienteModel salvarCliente(ClienteRequestDTO  clienteRequestDTO){
        if (clienteRepository.findByEmail(clienteRequestDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("Cliente já cadastrado");
        }
        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(clienteRequestDTO.getNome());
        novoCliente.setEmail(clienteRequestDTO.getEmail());
        novoCliente.setTelefone(clienteRequestDTO.getTelefone());
        novoCliente.setFormaPagamento(clienteRequestDTO.getFormaPagamento());
        novoCliente.setEndereco(clienteRequestDTO.getEndereco());
        novoCliente.setSenha(bCryptPasswordEncoder.encode(clienteRequestDTO.getSenha()));

        clienteRepository.save(novoCliente);
        return novoCliente;

    }
    public List<ClienteResponseDTO> ListaTodos(){
        return clienteRepository
                .findAll()
                .stream()
                .map(u -> new ClienteResponseDTO(u.getNome(), u.getEmail()))
                .toList();
    }
    public ClienteModel atualizarCliente(Long id, ClienteRequestDTO dto){
        if (!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado ");
        }
        ClienteModel atualizarCliente = new ClienteModel();
        atualizarCliente.setId(id);
        atualizarCliente.setNome(dto.getNome());
        atualizarCliente.setEmail(dto.getEmail());
        atualizarCliente.setTelefone(dto.getTelefone());
        atualizarCliente.setFormaPagamento(dto.getFormaPagamento());
        atualizarCliente.setEndereco(dto.getEndereco());
        atualizarCliente.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));

        clienteRepository.save(atualizarCliente);
        return atualizarCliente;
    }
    public void excluir(Long id){
        if (!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }





}
