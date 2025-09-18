package com.example.aula1709.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tab_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL) // SE UM CLIENTE FOR APAGADO SEU ENDERECO TBM
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Setor setor;

    public Cliente(){

    }

    public Cliente(UUID id, String nome, String email, Endereco endereco, Setor setor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.setor = setor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", setor=" + setor +
                '}';
    }
}
