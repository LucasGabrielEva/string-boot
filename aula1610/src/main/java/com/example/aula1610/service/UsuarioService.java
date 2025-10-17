package com.example.aula1610.service;

import com.example.aula1610.dto.UsuarioRequestDTO;
import com.example.aula1610.dto.UsuarioResponseDTO;
import com.example.aula1610.model.UsuarioModel;
import com.example.aula1610.repository.UsuarioRepository;
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
        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(usuarioRequestDTO.getNome());
        novoUsuario.setEmail(usuarioRequestDTO.getEmail());
        //Criptografando a senha antes de salva no banco de dados
        novoUsuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));

        usuarioRepository.save(novoUsuario);
        return novoUsuario;
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
   public UsuarioModel atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        UsuarioModel atualizarUsuario = new UsuarioModel();
        atualizarUsuario.setId(id);
        atualizarUsuario.setNome(dto.getNome());
        atualizarUsuario.setEmail(dto.getEmail());
        //Criptografia a senha antes de salva
        atualizarUsuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));

        usuarioRepository.save(atualizarUsuario);
        return atualizarUsuario;
   }
   //delete
    public void excluirUsuario(Long id) {
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario não encontrado");
        }
        usuarioRepository.deleteById(id);
    }


}
