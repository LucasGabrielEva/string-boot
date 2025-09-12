package com.example.projeto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_cliente") // cria o nome da tabela
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamento a numeracao de id
    private Long id; // o long substitui o int pois contem mais numeros

    @Column(nullable = false)
    private String nome; // nao pode ser vazio

    @Column(nullable = false) // nao pode ser vazio
    private String telefone;
    public Cliente(){

    }

    public Cliente(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
