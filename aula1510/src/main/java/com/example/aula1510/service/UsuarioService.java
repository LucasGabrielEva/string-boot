package com.example.aula1510.service;

import com.example.aula1510.dto.UsuarioRequestDTO;
import com.example.aula1510.dto.UsuarioResponseDTO;
import com.example.aula1510.model.UsuarioModel;
import com.example.aula1510.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    //Salvar
    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuario já cadastrado");
        }
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        //Criptografando a senha antes de salva no banco de dados
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));

        usuarioRepository.save(usuario);
        return usuario;
    }
    // Consulta tabela no banco de dados
    public List<UsuarioResponseDTO> ListaTodos(){
        return usuarioRepository
                // Retorna com os dados de todos os usuarios na tabela.
                .findAll()
                // Envia dados obtidos para as proximas funcções abaixo.
                .stream()
                // Envia somente os dados necessários para resposta.
                .map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail()))
                //Transforma todos os dados em uma Lista.
                .toList();
    }

}
